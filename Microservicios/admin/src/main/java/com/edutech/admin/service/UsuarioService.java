package com.edutech.admin.service;

import com.edutech.admin.model.Usuario;
import com.edutech.admin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario crear(Usuario u) { return repo.save(u); }
    public List<Usuario> listar() { return repo.findAll(); }
    public Optional<Usuario> obtener(Long id) { return repo.findById(id); }
    public Usuario actualizar(Usuario u) { return repo.save(u); }
    public void eliminar(Long id) { repo.deleteById(id); }
    public Usuario desactivar(Long id) {
        Usuario u = repo.findById(id).orElseThrow();
        u.setEstado("desactivado");
        return repo.save(u);
    }
}
