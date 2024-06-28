package com.si.apirest.model.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.dto.NotaVentaDTO;
import com.si.apirest.model.dto.ReportVentaDTO;
import com.si.apirest.model.service.NotaVentaService;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private NotaVentaService notaVentaService;

    @GetMapping("/bitacora")
    public ResponseEntity<byte[]> generateReport(@RequestParam String format, @RequestParam int id) throws Exception {
        // Obtener datos
        NotaVentaDTO notaVenta = notaVentaService.getNotaVenta(id);
        if (notaVenta==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ReportVentaDTO> reportVentaDTOs = new ArrayList<ReportVentaDTO>();
        BigDecimal total = notaVentaService.findTotalVenta(id);
        reportVentaDTOs = notaVentaService.findReporteVenta(id);
        reportVentaDTOs.add(0,new ReportVentaDTO("-",1,new BigDecimal(0),1.0,1.0));
        
        // Cargar el archivo .jrxml
        InputStream reportStream = new ClassPathResource("reports/Example1.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // Parámetros del reporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("total", total);
        parameters.put("fecha", notaVenta.getFecha());
        parameters.put("cliente", notaVenta.getPerson().getNombre());

        // Crear el datasource del reporte
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportVentaDTOs);

        // Llenar el reporte con datos
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();

        switch (format.toLowerCase()) {
            case "pdf":
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                headers.add("Content-Disposition", "attachment; filename=bitacora_report.pdf");
                break;
            case "xlsx":
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

                SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                configuration.setDetectCellType(true);
                configuration.setCollapseRowSpan(false);
                exporter.setConfiguration(configuration);

                exporter.exportReport();
                headers.add("Content-Disposition", "attachment; filename=bitacora_report.xlsx");
                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }


}





