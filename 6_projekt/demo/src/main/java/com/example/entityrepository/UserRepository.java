package com.example.entityrepository;

import com.example.entity.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    List<user> findByName(String name);

    List<user> findByAge(int age);

    List<user> findByNameAndAge(String name, int age);
}
