package com.example.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class userDto {

    private Long id; // Optional für Response, nicht für Erstellung nötig

    @NotBlank(message = "Name darf nicht leer sein")
    @Size(max = 100, message = "Name darf maximal 100 Zeichen haben")
    private String name;

    @Min(value = 0, message = "Age muss mindestens 0 sein")
    private int age;

    public userDto() {
    }

    public userDto(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
