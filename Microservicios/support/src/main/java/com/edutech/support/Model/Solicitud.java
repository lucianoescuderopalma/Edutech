package com.edutech.support.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String estado; // "pendiente", "en_proceso", "resuelto"

    @ManyToOne
    private SoporteTecnico tecnicoAsignado;
}