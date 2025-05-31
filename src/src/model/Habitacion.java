package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nro;

    @Column(name = "occuped")
    private boolean occuped;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Habitacion() {}

    public Habitacion(int nro, boolean occuped) {
        this.nro = nro;
        this.occuped = occuped;
    }
}
