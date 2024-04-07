package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.TipoPago;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.exceptions.TipoPagoException;
import com.si.apirest.model.repository.TipoPagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoPagoService {
    
    @Autowired
    private final TipoPagoRepository tipoPagoRepository;

    public void createTipoPago(TipoPago tipoPago) {
        tipoPagoRepository.save(tipoPago);
    }

    public String deleteTipoPago(int id) {
        try {
            tipoPagoRepository.deleteById(id);
            return "Eliminación exitosa.";
        } catch (Exception ex) {
            throw new TipoPagoException("Error al intentar eliminar el TipoPago con id: " + id);
        }    
    }

    public List<TipoPago> getAllTipoPago() {
        return tipoPagoRepository.findAll();
    }

    public Optional<TipoPago> getTipoPago(int id) {
        return tipoPagoRepository.findById(id);
    }

    public String deleteAllTipoPago() {
        try {
            tipoPagoRepository.deleteAll();
            return "Se vació correctamente TipoPago.";
        } catch (Exception e) {
            throw new TipoPagoException("Ocurrió un error al intentar vaciar TipoPago. \n" + e.getMessage());
        }
    }

    public ResponseEntity<OkResponse> updateTipoPago(TipoPago tipoPago){ 
        String texto = "Actualización de TipoPago exitosa.";

        if (tipoPago.getId()==null){
            texto = "Valor id necesario";
            return ResponseEntity.ok(OkResponse.builder()
            .message(texto)
            .build());
        }            

        tipoPagoRepository.save(tipoPago);

        return ResponseEntity.ok(OkResponse.builder()
        .message(texto)
        .build());
    }

}
