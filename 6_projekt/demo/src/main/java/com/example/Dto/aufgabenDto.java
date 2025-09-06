package com.example.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class aufgabenDto {

    @NotBlank(message = "Title darf nicht leer sein")
    @Size(max = 100, message = "Title darf maximal 100 Zeichen haben")
    private String title;

    @NotBlank(message = "Description darf nicht leer sein")
    @Size(max = 500, message = "Description darf maximal 500 Zeichen haben")
    private String description;

    @NotBlank(message = "DueDate darf nicht leer sein")
    private String dueDate; // optional: besser LocalDate verwenden

    private Long userId; // User-ID zur Zuordnung

    public aufgabenDto() {}

    public aufgabenDto(String title, String description, String dueDate, Long userId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    // Getter & Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
