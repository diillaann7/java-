package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.mitarbeiter;

public interface mitarbeiterrepository extends JpaRepository<mitarbeiter, Integer> {
    Optional<mitarbeiter> findByName(String name); // für getByName

}
