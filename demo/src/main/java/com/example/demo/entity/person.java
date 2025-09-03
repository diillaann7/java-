package com.example.demo.entity;

import com.example.demo.Dto.personDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "schnitt", nullable = false)
    private int schnitt;

    public person() {
    }

    public person(String name, int schnitt) {
        this.name = name;
        this.schnitt = schnitt;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchnitt() {
        return schnitt;
    }

    public void setSchnitt(int schnitt) {
        this.schnitt = schnitt;
    }
}
