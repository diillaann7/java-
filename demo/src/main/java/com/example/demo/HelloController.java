package com.example.demo;

import com.example.demo.Exception.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.Dto.requestDto.*;

import com.example.demo.Dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class HelloController {

    private final PersonRepository personRepository;
    private final mitarbeiterrepository mitres;

    public HelloController(PersonRepository personRepository, mitarbeiterrepository mitres) {
        this.personRepository = personRepository;
        this.mitres = mitres;
    }

    // ------------------ PERSON ------------------

    @PostMapping("/datenputten")
    public ResponseEntity<List<person>> postMethodName(@RequestBody PersonRequestDto p) {
        person s = new person(p.getName(), p.getSchnitt());
        personRepository.save(s);
        List<person> arr = personRepository.findAll();
        return ResponseEntity.ok(arr);
    }

    @GetMapping("/getname")
    public ResponseEntity<person> getMethodName(@RequestParam String name1) {
        Optional<person> p = personRepository.findByName(name1);
        if (p.isPresent()) {
            personDto person = new personDto(p.get().getName());
            return ResponseEntity.ok(p.get());
        } else {
            throw new mitarbeiternotfoundexception("Person mit Name " + name1 + " existiert nicht"); // 404
        }
    }

    @GetMapping("/getalle")
    public ResponseEntity<List<personDto>> getAllPersons() {
        List<personDto> all = personRepository.findAll()
                .stream()
                .map(p -> new personDto(p.getName()))
                .toList();

        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/deletename")
    public ResponseEntity<List<person>> deleteMethodName(@RequestParam String name1) {
        Optional<person> p = personRepository.findByName(name1);
        if (p.isPresent()) {
            personRepository.delete(p.get());
            List<person> arr = personRepository.findAll();
            return ResponseEntity.ok(arr);
        } else {
            throw new mitarbeiternotfoundexception("Person mit Name " + name1 + " existiert nicht"); // 404
        }
    }

    // ------------------ MITARBEITER ------------------

    @PutMapping("/putmitarbeiter/{id}")
    public ResponseEntity<String> putMitarbeiter(
            @Valid @PathVariable Integer id,
            @RequestBody mitarbeiter neuerMitarbeiter) {

        Optional<mitarbeiter> vorhanden = mitres.findById(id);

        if (vorhanden.isPresent()) {
            return ResponseEntity.ok("Mitarbeiter mit ID " + id + " existiert bereits, keine Aktion durchgeführt.");
        } else {
            if (neuerMitarbeiter.getGehalt() < 0) {
                throw new meineexception("Gehalt darf nicht negativ sein"); // 400
            }
            neuerMitarbeiter.setid(id);
            mitres.save(neuerMitarbeiter);
            return ResponseEntity.status(201).body("Mitarbeiter mit ID " + id + " wurde neu angelegt!");
        }
    }

    @GetMapping("/getmitarbeiter/{id}")
    public ResponseEntity<?> getMethodName(@Valid @PathVariable int id) {
        Optional<mitarbeiter> x = mitres.findById(id);
        if (x.isPresent()) {
            mitarbeiterDto mitarbeiter = new mitarbeiterDto(x.get().getName(), x.get().getNachname());
            return ResponseEntity.ok(mitarbeiter);
        } else {
            throw new mitarbeiternotfoundexception("der mitarbeiter existiert nicht"); // 404
        }
    }

    @DeleteMapping("/deletemitarbeiter/{id}")
    public ResponseEntity<?> deletemethodename(@PathVariable int id) {
        Optional<mitarbeiter> x = mitres.findById(id);
        if (x.isPresent()) {
            mitres.deleteById(id);
            return ResponseEntity.ok("Der Mitarbeiter wurde gelöscht");
        } else {
            throw new mitarbeiternotfoundexception("Der Mitarbeiter existiert nicht"); // 404
        }
    }
}
