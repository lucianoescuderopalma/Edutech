package com.edutech.support.Controller;

import com.edutech.support.Model.Solicitud;
import com.edutech.support.Service.LogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support/solicitudes")
public class LogisticaController {

    @Autowired
    private LogisticaService service;

    @PostMapping
    public ResponseEntity<Solicitud> crear(@RequestBody Solicitud s) {
        return ResponseEntity.ok(service.crear(s));
    }

    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Solicitud> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        return ResponseEntity.ok(service.cambiarEstado(id, estado));
    }

    @PutMapping("/{id}/asignar")
    public ResponseEntity<Solicitud> asignar(@PathVariable Long id, @RequestParam Long tecnicoId) {
        return ResponseEntity.ok(service.asignarTecnico(id, tecnicoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}