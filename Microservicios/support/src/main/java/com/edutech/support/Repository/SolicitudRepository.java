package com.edutech.support.Repository;

import com.edutech.support.Model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    long countByEstado(String estado);
}