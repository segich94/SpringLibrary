package com.example.springlibrary.controller;

import com.example.springlibrary.model.Author;
import com.example.springlibrary.model.Book;
import com.example.springlibrary.service.AuthorService;
import com.example.springlibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class LibraryController {
    private final BookService bookService;
    private final AuthorService authorService;
    @GetMapping("/all")
    public Page<Book> getAllBooks(@RequestParam(value = "sort", required = false) String sortBy,
                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable;
        if (sortBy != null) {
            pageable = PageRequest.of(page, size, Sort.by(sortBy));
        } else {
            pageable = PageRequest.of(page, size);
        }

        return bookService.findAllBook(pageable);
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.findByBookId(id);
    }
    @PostMapping()
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteByBookId(id);
    }

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
}
