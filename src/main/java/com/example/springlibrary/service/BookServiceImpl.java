package com.example.springlibrary.service;

import com.example.springlibrary.model.Book;
import com.example.springlibrary.model.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Override
    public Book findByBookId(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        if (findByBookId(id) != null){
            Book oldBook = findByBookId(id);
            oldBook.setAuthor(book.getAuthor());
            oldBook.setYear(book.getYear());
            oldBook.setTitle(book.getTitle());
            return bookRepository.save(oldBook);
        }else {
            return null;
        }
    }

    @Override
    public void deleteByBookId(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAllBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
