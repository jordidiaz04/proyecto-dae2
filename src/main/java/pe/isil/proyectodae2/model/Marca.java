package pe.isil.proyectodae2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "marca")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    public boolean estado;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "idEmpresa", nullable = false)
    private Long idEmpresa;
}
