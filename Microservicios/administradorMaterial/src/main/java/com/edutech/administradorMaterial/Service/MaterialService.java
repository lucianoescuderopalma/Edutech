package com.edutech.administradorMaterial.Service;

import com.edutech.administradorMaterial.Model.*;
import com.edutech.administradorMaterial.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired private ContenidoRepository contenidoRepo;
    @Autowired private EvaluacionRepository evaluacionRepo;
    @Autowired private MensajeForoRepository foroRepo;
    @Autowired private ProgresoEstudianteRepository progresoRepo;

    // Contenido
    public Contenido guardarContenido(Contenido c) { return contenidoRepo.save(c); }
    public List<Contenido> listarContenidos() { return contenidoRepo.findAll(); }
    public Optional<Contenido> obtenerContenido(Long id) { return contenidoRepo.findById(id); }

    // Evaluaciones
    public Evaluacion guardarEvaluacion(Evaluacion e) { return evaluacionRepo.save(e); }
    public List<Evaluacion> listarEvaluaciones() { return evaluacionRepo.findAll(); }

    // Foro
    public MensajeForo guardarMensaje(MensajeForo m) { return foroRepo.save(m); }
    public List<MensajeForo> listarMensajes() { return foroRepo.findAll(); }

    // Progreso
    public ProgresoEstudiante guardarProgreso(ProgresoEstudiante p) { return progresoRepo.save(p); }
    public List<ProgresoEstudiante> listarProgreso() { return progresoRepo.findAll(); }
}
