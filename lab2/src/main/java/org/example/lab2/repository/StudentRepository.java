package org.example.lab2.repository;

import org.example.lab2.domain.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
