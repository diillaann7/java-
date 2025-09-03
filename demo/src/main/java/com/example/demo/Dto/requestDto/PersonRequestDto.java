package com.example.demo.Dto.requestDto;

public class PersonRequestDto {
    private String name;
    private int schnitt;

    public PersonRequestDto() {
    } // No-args Konstruktor für Spring

    public PersonRequestDto(String name, int schnitt) {
        this.name = name;
        this.schnitt = schnitt;
    }

    // Getter & Setter
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