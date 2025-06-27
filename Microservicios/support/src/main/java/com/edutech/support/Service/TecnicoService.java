package com.edutech.support.Service;

import com.edutech.support.Model.SoporteTecnico;
import com.edutech.support.Repository.SoporteTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {

    @Autowired
    private SoporteTecnicoRepository repo;

    public SoporteTecnico crear(SoporteTecnico t) {
        return repo.save(t);
    }

    public List<SoporteTecnico> listar() {
        return repo.findAll();
    }
}