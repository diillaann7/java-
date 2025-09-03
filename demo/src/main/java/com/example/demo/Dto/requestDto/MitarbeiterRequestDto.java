package com.example.demo.Dto.requestDto;

public class MitarbeiterRequestDto {

    private String name;
    private String nachname;

    // No-args Konstruktor für Spring
    public MitarbeiterRequestDto() {
    }

    // All-args Konstruktor
    public MitarbeiterRequestDto(String name, String nachname) {
        this.name = name;
        this.nachname = nachname;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
