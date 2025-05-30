package Controller;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetails) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);
        if (!optionalEstudiante.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Estudiante estudiante = optionalEstudiante.get();
        estudiante.setNombre(estudianteDetails.getNombre());
        estudiante.setApellido(estudianteDetails.getApellido());
        estudiante.setEmail(estudianteDetails.getEmail());
        estudiante.setTelefono(estudianteDetails.getTelefono());
        estudiante.setPreferencias(estudianteDetails.getPreferencias());
        estudiante.setCursosInscritos(estudianteDetails.getCursosInscritos());
        estudiante.setProgresoTotal(estudianteDetails.getProgresoTotal());
        estudiante.setCuponesDescuento(estudianteDetails.getCuponesDescuento());
        Estudiante updatedEstudiante = estudianteRepository.save(estudiante);
        return ResponseEntity.ok(updatedEstudiante);
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
