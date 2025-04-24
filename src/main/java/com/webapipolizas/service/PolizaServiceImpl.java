package com.webapipolizas.service;

import com.webapipolizas.model.Poliza;
import com.webapipolizas.repository.PolizaRepository;
import com.webapipolizas.service.PolizaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolizaServiceImpl implements PolizaService {

    private final PolizaRepository polizaRepository;

    public PolizaServiceImpl(PolizaRepository polizaRepository) {
        this.polizaRepository = polizaRepository;
    }

    @Override
    public List<Poliza> listarTodas() {
        return polizaRepository.findAll();
    }

    @Override
    public Poliza guardar(Poliza poliza) {
        return polizaRepository.save(poliza);
    }

    @Override
    public Poliza actualizar(Poliza poliza) {
        return polizaRepository.save(poliza);
    }

    @Override
    public void eliminar(String numeroPoliza) {
        polizaRepository.deleteById(numeroPoliza);
    }

    @Override
    public List<Poliza> buscarPorCedula(String cedula) {
        return polizaRepository.findByCedulaAsegurado(cedula);
    }

}
