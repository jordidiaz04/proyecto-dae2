package pe.isil.proyectodae2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Column(name = "estado", nullable = false)
    public boolean estado;

    @Column(name = "idCategoria", nullable = false)
    private Long idCategoria;

    @Column(name = "idMarca", nullable = false)
    private Long idMarca;
}
