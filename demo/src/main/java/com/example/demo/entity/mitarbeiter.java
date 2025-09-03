package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "mitarbeiter")
public class mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "der name darf nicht leer sein")
    private String name;

    @Column(name = "nachname", nullable = false)
    private String nachname;

    @Column(name = "gehalt", nullable = false)
    @Min(value = 0, message = "der mitarbeiter muss mindestes 0 euro verdienen")
    @Max(value = 3000, message = "der mitarbeiter darf maximal 3000 euro verdienen")

    private int gehalt;

    public mitarbeiter() {
    }

    public mitarbeiter(String name, String nachname, int gehalt) {
        this.name = name;
        this.nachname = nachname;
        this.gehalt = gehalt;
    }

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setid(int x) {
        this.id = x;
    }

    public String getName() {
        return name;
    }

    public String getNachname() {
        return nachname;
    }

    public int getGehalt() {
        return gehalt;
    }
}
