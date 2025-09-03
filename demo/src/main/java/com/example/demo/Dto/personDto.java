package com.example.demo.Dto;

// Response DTO: nur Felder, die zurückgegeben werden
public class personDto {
    private String name;

    public personDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
