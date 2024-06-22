package com.si.apirest.model.repository;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.dto.ReportVentaDTO;
import com.si.apirest.model.entity.NotaVenta;

import jakarta.transaction.Transactional;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVenta, Integer>{
    @Query("SELECT new com.si.apirest.model.dto.ReportVentaDTO(" +
       "prd.nombre, dv.cantidad, prd.precio, " +
       "(prd.precio * dv.cantidad * (1 - d.porcentaje / 100.0)), " +
       "(d.porcentaje * prd.precio / 100.0)) " +
       "FROM NotaVenta nv " +
       "JOIN nv.detalleVenta dv " +
       "JOIN dv.producto prd " +
       "JOIN prd.descuento d " +
       "WHERE nv.id = ?1")
    List<ReportVentaDTO> findVentaReportData(int id);

    @Procedure(name = "findTotalVenta")
    @Transactional()
    BigDecimal findTotalVenta(@Param("id") int id);
}
