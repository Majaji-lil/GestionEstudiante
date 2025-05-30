package Model;


import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String preferencias;

    @ElementCollection
    @CollectionTable(name = "estudiante_cursos", joinColumns = @JoinColumn(name = "estudiante_id"))
    @Column(name = "curso_id")
    private List<Long> cursosInscritos;

    private Double progresoTotal;

    @ElementCollection
    @CollectionTable(name = "estudiante_cupones", joinColumns = @JoinColumn(name = "estudiante_id"))
    @Column(name = "cupon")
    private List<String> cuponesDescuento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public List<Long> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<Long> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public Double getProgresoTotal() {
        return progresoTotal;
    }

    public void setProgresoTotal(Double progresoTotal) {
        this.progresoTotal = progresoTotal;
    }

    public List<String> getCuponesDescuento() {
        return cuponesDescuento;
    }

    public void setCuponesDescuento(List<String> cuponesDescuento) {
        this.cuponesDescuento = cuponesDescuento;
    }
}
