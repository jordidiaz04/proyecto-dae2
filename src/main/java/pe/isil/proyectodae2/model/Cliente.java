package pe.isil.proyectodae2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "dni", nullable = false)
    public String dni;

    @Column(name = "nombres", nullable = false)
    public String nombres;

    @Column(name = "apellidos", nullable = false)
    public String apellidos;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "telefono", nullable = false)
    public String telefono;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "estado", nullable = false)
    public String estado;

    @Column(name = "direccion", nullable = false)
    public String direccion;

}
