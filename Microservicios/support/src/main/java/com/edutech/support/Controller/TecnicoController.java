package com.edutech.support.Controller;

import com.edutech.support.Model.SoporteTecnico;
import com.edutech.support.Service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @PostMapping
    public ResponseEntity<SoporteTecnico> crear(@RequestBody SoporteTecnico t) {
        return ResponseEntity.ok(service.crear(t));
    }

    @GetMapping
    public ResponseEntity<List<SoporteTecnico>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}