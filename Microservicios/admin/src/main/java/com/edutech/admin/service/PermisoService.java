package com.edutech.admin.service;

import com.edutech.admin.model.Permiso;
import com.edutech.admin.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository repo;

    public Permiso guardar(Permiso p) { return repo.save(p); }
    public List<Permiso> listar() { return repo.findAll(); }
    public Optional<Permiso> obtener(Long id) {
        return repo.findById(id);

    }
    public Permiso actualizar(Permiso permiso) {
        return repo.save(permiso);
    }

}