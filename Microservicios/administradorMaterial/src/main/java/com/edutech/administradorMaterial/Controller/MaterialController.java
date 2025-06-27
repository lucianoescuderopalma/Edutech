package com.edutech.administradorMaterial.Controller;

import com.edutech.administradorMaterial.Model.*;
import com.edutech.administradorMaterial.Service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired private MaterialService service;

    @PostMapping("/contenido")
    public ResponseEntity<Contenido> crearContenido(@RequestBody Contenido c) {
        return ResponseEntity.ok(service.guardarContenido(c));
    }

    @GetMapping("/contenido")
    public ResponseEntity<List<Contenido>> listarContenido() {
        return ResponseEntity.ok(service.listarContenidos());
    }

    @PostMapping("/evaluacion")
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion e) {
        return ResponseEntity.ok(service.guardarEvaluacion(e));
    }

    @GetMapping("/evaluacion")
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        return ResponseEntity.ok(service.listarEvaluaciones());
    }

    @PostMapping("/foro")
    public ResponseEntity<MensajeForo> postMensaje(@RequestBody MensajeForo m) {
        return ResponseEntity.ok(service.guardarMensaje(m));
    }

    @GetMapping("/foro")
    public ResponseEntity<List<MensajeForo>> listarMensajes() {
        return ResponseEntity.ok(service.listarMensajes());
    }

    @PostMapping("/progreso")
    public ResponseEntity<ProgresoEstudiante> crearProgreso(@RequestBody ProgresoEstudiante p) {
        return ResponseEntity.ok(service.guardarProgreso(p));
    }

    @GetMapping("/progreso")
    public ResponseEntity<List<ProgresoEstudiante>> listarProgreso() {
        return ResponseEntity.ok(service.listarProgreso());
    }
}

