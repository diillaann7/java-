package com.example.entityrepository;

import com.example.entity.aufgaben;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AufgabenRepository extends JpaRepository<aufgaben, Long> {
    List<aufgaben> findByTitle(String title);

    List<aufgaben> findByTitleAndId(String title, Long id);

    List<aufgaben> findByUser_Id(Long userId); // <-- Korrektur
}
