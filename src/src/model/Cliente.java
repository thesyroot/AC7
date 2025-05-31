package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @OneToOne
    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
    private Habitacion habitacion;

    public Cliente() {}

    public Cliente(int id, String nombre, String apellido, Habitacion habitacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.habitacion = habitacion;
    }
}
