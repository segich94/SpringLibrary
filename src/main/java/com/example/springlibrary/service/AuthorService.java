package com.example.springlibrary.service;

import com.example.springlibrary.model.Author;

public interface AuthorService {
    Author getAuthorById(Long id);
    Author addAuthor(Author author);
}
