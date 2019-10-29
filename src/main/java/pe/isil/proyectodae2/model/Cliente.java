package pe.isil.proyectodae2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
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
    public Boolean estado;

    @Column(name = "direccion", nullable = false)
    public String direccion;

    @Column(name = "cuenta", nullable = false)
    public Boolean cuenta;

    @Column(name = "carrito", nullable = false)
    public Boolean carrito;

}
