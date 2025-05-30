package Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Estudiante;
import Repository.EstudianteRepository;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        return ResponseEntity.ok(estudianteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(savedEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(
            @PathVariable Long id,
            @RequestBody Estudiante estudianteDetails) {

        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteDetails.getNombre());
                    estudiante.setApellido(estudianteDetails.getApellido());
                    estudiante.setEmail(estudianteDetails.getEmail());
                    estudiante.setTelefono(estudianteDetails.getTelefono());
                    estudiante.setPreferencias(estudianteDetails.getPreferencias());
                    estudiante.setCursosInscritos(estudianteDetails.getCursosInscritos());
                    estudiante.setProgresoTotal(estudianteDetails.getProgresoTotal());
                    estudiante.setCuponesDescuento(estudianteDetails.getCuponesDescuento());
                    Estudiante updated = estudianteRepository.save(estudiante);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        if (!estudianteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estudianteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
