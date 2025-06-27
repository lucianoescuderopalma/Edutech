package com.edutech.support.Service;

import com.edutech.support.Model.Solicitud;
import com.edutech.support.Model.SoporteTecnico;
import com.edutech.support.Repository.SolicitudRepository;
import com.edutech.support.Repository.SoporteTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogisticaService {

    @Autowired
    private SolicitudRepository solicitudRepo;

    @Autowired
    private SoporteTecnicoRepository tecnicoRepo;

    public Solicitud crear(Solicitud s) {
        s.setEstado("pendiente");
        return solicitudRepo.save(s);
    }

    public List<Solicitud> listar() {
        return solicitudRepo.findAll();
    }

    public Optional<Solicitud> obtener(Long id) {
        return solicitudRepo.findById(id);
    }

    public void eliminar(Long id) {
        solicitudRepo.deleteById(id);
    }

    public Solicitud asignarTecnico(Long solicitudId, Long tecnicoId) {
        Solicitud solicitud = solicitudRepo.findById(solicitudId).orElseThrow();
        SoporteTecnico tecnico = tecnicoRepo.findById(tecnicoId).orElseThrow();
        solicitud.setTecnicoAsignado(tecnico);
        return solicitudRepo.save(solicitud);
    }

    public Solicitud cambiarEstado(Long solicitudId, String estado) {
        Solicitud solicitud = solicitudRepo.findById(solicitudId).orElseThrow();
        solicitud.setEstado(estado);
        return solicitudRepo.save(solicitud);
    }
}