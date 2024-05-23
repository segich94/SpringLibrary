package com.example.springlibrary.service;

import com.example.springlibrary.model.Author;
import com.example.springlibrary.model.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;
    @Override
    @Transactional(readOnly = true)
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
}
