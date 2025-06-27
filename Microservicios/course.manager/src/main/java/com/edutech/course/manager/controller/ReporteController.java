package com.edutech.course.manager.controller;
import com.edutech.course.manager.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @GetMapping("/resumen")
    public ResponseEntity<String> obtenerResumen() {
        return ResponseEntity.ok(service.generarResumen());
    }
}
