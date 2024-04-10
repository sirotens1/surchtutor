package com.example.surchtutor.repositories;

import com.example.surchtutor.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
