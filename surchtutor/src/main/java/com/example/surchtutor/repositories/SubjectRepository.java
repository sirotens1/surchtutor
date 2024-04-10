package com.example.surchtutor.repositories;

import com.example.surchtutor.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByTitle(String title);
}
