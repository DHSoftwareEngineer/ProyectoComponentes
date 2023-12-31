package com.example.proyectocomponentes.repository;

import com.example.proyectocomponentes.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITrainer extends JpaRepository<Trainer, Integer> {
    @Query("SELECT t.firstName ||' ' || t.lastName FROM Trainer t WHERE t.firstName = :name")
    public String byName(@Param("name")String name);
}
