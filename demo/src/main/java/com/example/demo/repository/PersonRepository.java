package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.entity.person;

public interface PersonRepository extends JpaRepository<person, Long> {
    Optional<person> findByName(String name); // für getByName
}
