package com.webapipolizas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Polizas")
public class Poliza {

    @Id
    @Column(name = "NumeroPoliza")
    private String numeroPoliza;

    @Column(name = "TipoPolizaId")
    private Integer tipoPolizaId;

    @Column(name = "CedulaAsegurado")
    private String cedulaAsegurado;

    @Column(name = "MontoAsegurado")
    private Double montoAsegurado;

    @Column(name = "FechaVencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "FechaEmision")
    private LocalDate fechaEmision;

    @Column(name = "CoberturaId")
    private Integer coberturaId;

    @Column(name = "EstadoPolizaId")
    private Integer estadoPolizaId;

    @Column(name = "Prima")
    private Double prima;

    @Column(name = "Periodo")
    private LocalDate periodo;

    @Column(name = "FechaInclusion")
    private LocalDate fechaInclusion;

    @Column(name = "AseguradoraId")
    private Integer aseguradoraId;
}
