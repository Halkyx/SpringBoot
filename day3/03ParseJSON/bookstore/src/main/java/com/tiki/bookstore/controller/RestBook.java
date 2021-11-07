package com.tiki.bookstore.controller;


import com.tiki.bookstore.model.Book;
import com.tiki.bookstore.repository.BookStoreRepository;
import com.tiki.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book/")
public class RestBook {

    private BookService bookService;

    @Autowired
    public RestBook(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("id")
    public ResponseEntity<Book> getBook(@RequestParam(value = "id") int id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("add")
    public ResponseEntity<List<Book>> add(@RequestParam(value = "id") int id,
                                          @RequestParam(value = "title") String title,
                                          @RequestParam(value = "description") String description) {
        Book book = new Book(id, title, description);
        bookService.add(book);

        List<Book> bookList = bookService.getAll();
        return ResponseEntity.ok().body(bookList);
    }


    @PutMapping("update")
    public ResponseEntity<List<Book>> update(@RequestParam(value = "id") int id,
                                             @RequestParam(value = "title", required = false) String title,
                                             @RequestParam(value = "description", required = false) String description) {
        bookService.update(id, title, description);

        List<Book> bookList = bookService.getAll();
        return ResponseEntity.ok().body(bookList);
    }

    @DeleteMapping("delete")
    public ResponseEntity<List<Book>> delete(@RequestParam(value = "id") int id) {
        bookService.delete(id);

        List<Book> bookList = bookService.getAll();
        return ResponseEntity.ok().body(bookList);
    }

}
