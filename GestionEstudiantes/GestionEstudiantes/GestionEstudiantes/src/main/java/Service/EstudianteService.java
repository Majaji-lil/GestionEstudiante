package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Estudiante;
import Repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudianteById(Long id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> updateEstudiante(Long id, Estudiante estudianteDetails) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);
        if (!optionalEstudiante.isPresent()) {
            return Optional.empty();
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
        return Optional.of(estudianteRepository.save(estudiante));
    }

    public boolean deleteEstudiante(Long id) {
        if (!estudianteRepository.existsById(id)) {
            return false;
        }
        estudianteRepository.deleteById(id);
        return true;
    }
}
