package ru.ras.handbook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand", length = 64, nullable = false)
    private String brand;

    @Column(name = "model", length = 64, nullable = false)
    private String model;

    @Column(name = "released")
    private Date released;

}
