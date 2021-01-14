package com.example.repository;

import com.example.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    @Query("SELECT p FROM Parent p WHERE p.id = ?1")
    Parent findById(long id);
}
