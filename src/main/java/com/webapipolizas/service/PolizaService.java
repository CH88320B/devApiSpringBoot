package com.webapipolizas.service;

import com.webapipolizas.model.Poliza;
import java.util.List;
public interface PolizaService {
    List<Poliza> listarTodas();
    List<Poliza> buscarPorCedula(String cedula);
    Poliza guardar(Poliza poliza);
    Poliza actualizar(Poliza poliza);
    void eliminar(String numeroPoliza);
}
