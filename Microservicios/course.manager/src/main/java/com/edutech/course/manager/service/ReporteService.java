package com.edutech.course.manager.service;
import com.edutech.course.manager.model.Curso;
import com.edutech.course.manager.repository.CursoRepository;
import com.edutech.course.manager.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public String generarResumen() {
        long totalCursos = cursoRepository.count();
        long cursosAprobados = cursoRepository.countByAprobadoTrue();
        long totalInstructores = instructorRepository.count();

        return """
                📊 Reporte General:
                - Total de Cursos: %d
                - Cursos Aprobados: %d
                - Total de Instructores: %d
                """.formatted(totalCursos, cursosAprobados, totalInstructores);
    }
}
