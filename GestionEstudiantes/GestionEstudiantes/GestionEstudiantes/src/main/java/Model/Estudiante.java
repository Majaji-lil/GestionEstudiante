package Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String preferencias;
    private List<Long> cursosInscritos; 
    private Double progresoTotal; 
    private List<String> cuponesDescuento; 
}
