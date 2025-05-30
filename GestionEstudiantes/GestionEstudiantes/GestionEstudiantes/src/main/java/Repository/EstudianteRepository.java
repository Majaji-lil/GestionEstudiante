package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

}
