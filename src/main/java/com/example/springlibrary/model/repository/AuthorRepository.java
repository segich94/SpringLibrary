package com.example.springlibrary.model.repository;

import com.example.springlibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
