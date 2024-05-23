package com.example.springlibrary.service;

import com.example.springlibrary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Book findByBookId(Long id);

    Book addBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteByBookId(Long id);

    Page<Book> findAllBook(Pageable pageable);
}
