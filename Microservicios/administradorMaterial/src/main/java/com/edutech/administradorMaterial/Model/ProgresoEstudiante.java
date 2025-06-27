package com.edutech.administradorMaterial.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProgresoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estudiante;
    private String curso;
    private String avance; // ejemplo: "75%"
}
