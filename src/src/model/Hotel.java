package model;

import jakarta.persistence.*;
import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.ArrayList;

@Data // agrega setters, getters y toString
@Entity
@Table(name = "Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Habitacion> habitaciones;

    public Hotel() {}

    public Hotel(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;

        this.habitaciones = new ArrayList<>();
    }

    public void addHabitaciones(Habitacion h){
        this.getHabitaciones().add(h);
    }
}
