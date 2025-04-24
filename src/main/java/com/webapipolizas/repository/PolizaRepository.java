package com.webapipolizas.repository;

import com.webapipolizas.dto.LoginRequest;
import com.webapipolizas.model.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza, String> {

    // Buscar pólizas por la cédula del asegurado
    List<Poliza> findByCedulaAsegurado(String cedulaAsegurado);

    }
