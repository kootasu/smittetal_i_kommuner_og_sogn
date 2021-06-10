package com.example.demo.repository;

import com.example.demo.model.Parish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParishRepository extends JpaRepository<Parish, Long> {
}
