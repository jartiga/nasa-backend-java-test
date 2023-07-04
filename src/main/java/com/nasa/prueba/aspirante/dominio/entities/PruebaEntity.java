package com.nasa.prueba.aspirante.dominio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nasa_data")
@Getter @Setter
public class PruebaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String href;
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String center;
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String title;
    @Column(name = "nasa_id", columnDefinition = "varchar(250)", nullable = false)
    private String nasaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PruebaEntity entity = (PruebaEntity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
