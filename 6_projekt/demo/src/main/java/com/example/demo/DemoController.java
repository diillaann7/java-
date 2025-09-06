package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.fehler;
import com.example.entity.aufgaben;
import com.example.entity.user;
import com.example.entityrepository.AufgabenRepository;
import com.example.entityrepository.UserRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DemoController {

    private final AufgabenRepository aufgabenRepository;
    private final UserRepository userRepository;
    private final DemoService demoService;

    public DemoController(AufgabenRepository aufgabenRepository, UserRepository userRepository,
            DemoService demoService) {
        this.aufgabenRepository = aufgabenRepository;
        this.userRepository = userRepository;
        this.demoService = demoService;
    }

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorld(@RequestParam String param) {
        return ResponseEntity.ok("Hello World! " + param);
    }

    @GetMapping("/getaufgaben")
    public ResponseEntity<List<aufgaben>> getAufgaben(@RequestParam String name) {
        List<aufgaben> aufgaben = demoService.getAufgabenByUserName(name);
        return ResponseEntity.ok(aufgaben);
    }

    @DeleteMapping("/aufgabenloeschen")
    public ResponseEntity<String> aufgabenloeschen(@RequestParam String title, @RequestParam String name) {
        demoService.aufgabenloeschen(title, name);
        return ResponseEntity.ok("Aufgabe gelöscht");
    }

    @PutMapping("path/{id}")
    public ResponseEntity putMethodName(@PathVariable String name, @RequestBody aufgaben aufgabe) {
        demoService.aufgabeHinzufuegen(aufgabe, name);
        return ResponseEntity.ok("Aufgabe hinzugefügt");
    }

}
