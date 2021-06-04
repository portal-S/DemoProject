package com.ntiteam.demoProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "overlords")
public class Overlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @JsonIgnore
    @OneToMany(mappedBy = "overlord")
    private List<Planet> planets;

    public Overlord() {
    }

    public Overlord(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "Overlord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Overlord overlord = (Overlord) o;
        return id == overlord.id && age == overlord.age && Objects.equals(name, overlord.name) && Objects.equals(planets, overlord.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, planets);
    }
}

