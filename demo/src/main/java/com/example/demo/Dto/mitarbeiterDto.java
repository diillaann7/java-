package com.example.demo.Dto;

public class mitarbeiterDto {
    private String name;
    private String nachname;

    public mitarbeiterDto(String name, String nachname) {
        this.name = name;
        this.nachname = nachname;
    }

    public String getname() {
        return this.name;
    }

    public String getnachname() {
        return this.nachname;
    }

}
