package com.webapipolizas.controller;

import com.webapipolizas.model.Poliza;
import com.webapipolizas.service.PolizaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poliza")
@Tag(name = "Pólizas", description = "Operaciones CRUD para gestión de pólizas")
public class PolizaController {

    @Autowired
    private PolizaService polizaService;

    @Operation(
            summary = "Listar pólizas",
            description = "Obtiene el listado completo de pólizas registradas en la base de datos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Listado exitoso")
            }
    )
    @GetMapping("/lista")
    public ResponseEntity<List<Poliza>> listar() {
        return ResponseEntity.ok(polizaService.listarTodas());
    }

    @Operation(
            summary = "Guardar póliza",
            description = "Registra una nueva póliza en la base de datos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Póliza guardada correctamente")
            }
    )
    @PostMapping("/guardar")
    public ResponseEntity<Poliza> guardar(@RequestBody Poliza poliza) {
        return ResponseEntity.ok(polizaService.guardar(poliza));
    }

    @Operation(
            summary = "Actualizar póliza",
            description = "Actualiza una póliza existente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Póliza actualizada correctamente")
            }
    )
    @PutMapping("/actualizar")
    public ResponseEntity<Poliza> actualizar(@RequestBody Poliza poliza) {
        return ResponseEntity.ok(polizaService.actualizar(poliza));
    }

    @Operation(
            summary = "Eliminar póliza",
            description = "Elimina una póliza según su número",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Póliza eliminada correctamente")
            }
    )
    @DeleteMapping("/eliminar/{numeroPoliza}")
    public ResponseEntity<Void> eliminar(@PathVariable String numeroPoliza) {
        polizaService.eliminar(numeroPoliza);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Buscar pólizas por cédula",
            description = "Retorna las pólizas relacionadas a una cédula de asegurado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Consulta exitosa")
            }
    )
    @GetMapping("/buscarPorCedula/{cedula}")
    public ResponseEntity<List<Poliza>> buscarPorCedula(@PathVariable String cedula) {
        return ResponseEntity.ok(polizaService.buscarPorCedula(cedula));
    }
}
