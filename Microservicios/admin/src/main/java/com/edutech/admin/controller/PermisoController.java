package com.edutech.admin.controller;

import com.edutech.admin.model.Permiso;
import com.edutech.admin.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/permiso")
public class PermisoController {

    @Autowired
    private PermisoService service;

    @PostMapping
    public ResponseEntity<Permiso> guardar(@RequestBody Permiso p) {
        return ResponseEntity.ok(service.guardar(p));
    }

    @GetMapping
    public ResponseEntity<List<Permiso>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> obtenerPorId(@PathVariable Long id) {
        Optional<Permiso> permiso = service.obtener(id);
        return permiso.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Permiso> actualizar(@PathVariable Long id, @RequestBody Permiso permiso) {
        Optional<Permiso> existente = service.obtener(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        permiso.setId(id);
        return ResponseEntity.ok(service.actualizar(permiso));
    }

}
