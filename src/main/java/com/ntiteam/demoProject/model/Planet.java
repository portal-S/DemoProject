package com.ntiteam.demoProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lord_id")
    private Overlord overlord;

    public Planet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Overlord getOverlord() {
        return overlord;
    }

    public void setOverlord(Overlord overlord) {
        this.overlord = overlord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id && Objects.equals(name, planet.name) && Objects.equals(overlord, planet.overlord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, overlord);
    }
}
