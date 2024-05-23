package com.example.springlibrary.model.repository;

import com.example.springlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<Book, Long>, PagingAndSortingRepository<Book,Long> {
}
