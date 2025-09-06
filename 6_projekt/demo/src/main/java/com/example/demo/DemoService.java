package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Exception.fehler;
import com.example.entity.aufgaben;
import com.example.entity.user;
import com.example.entityrepository.AufgabenRepository;
import com.example.entityrepository.UserRepository;

@Service
public class DemoService {
    private final AufgabenRepository aufgabenRepository;
    private final UserRepository userRepository;

    public DemoService(AufgabenRepository aufgabenRepository, UserRepository userRepository) {
        this.aufgabenRepository = aufgabenRepository;
        this.userRepository = userRepository;
    }

    public List<aufgaben> getAufgabenByUserName(String name) {
        List<user> benutzer = userRepository.findByName(name);
        if (benutzer.isEmpty()) {
            throw new fehler("Benutzer nicht gefunden");
        }
        Long id = benutzer.get(0).getId();
        return aufgabenRepository.findByUser_Id(id);
    }

    public void aufgabenloeschen(String title, String name) {
        List<user> benutzer = userRepository.findByName(name);
        Long id = benutzer.get(0).getId();
        List<aufgaben> aufgaben = aufgabenRepository.findByTitle(title);
        if (aufgaben.isEmpty()) {
            throw new fehler("Aufgabe nicht gefunden");
        }
        List<aufgaben> aufgaben1 = aufgabenRepository.findByTitleAndId(title, id);
        if (aufgaben1.isEmpty()) {
            throw new fehler("Aufgabe nicht gefunden");
        } else {
            aufgabenRepository.delete(aufgaben1.get(0));
        }
    }

    public void aufgabeHinzufuegen(aufgaben aufgabe, String name) {
        List<user> benutzerListe = userRepository.findByName(name);

        if (benutzerListe.isEmpty()) {
            throw new fehler("Benutzer nicht gefunden");
        }

        user benutzer = benutzerListe.get(0); // User-Objekt
        aufgabe.setUser(benutzer); // Aufgabe dem User zuordnen
        aufgabenRepository.save(aufgabe); // Aufgabe speichern
    }

}