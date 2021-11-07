package com.tiki.bookstore.service;

import com.tiki.bookstore.model.Book;
import com.tiki.bookstore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BookService {

    @Autowired
    BookStoreRepository bookStoreRepository;

    public BookService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<Book> getAll() {
        return bookStoreRepository.getAll();
    }

    public Book getBook(int id) {
        Optional<Book> optional = bookStoreRepository.get(id);
        final Book[] myBook = {null};
        optional.ifPresent(book -> myBook[0] = book);
        return myBook[0];
    }

    public void add(Book book) {
        bookStoreRepository.add(book);
    }

    public void update(int id, String title, String description) {
        Book book = getBook(id);
        if (book != null) {
            if (!Objects.equals(title, "")) {
                book.setTitle(title);
            }
            if (!Objects.equals(description, "")) {
                book.setDescription(description);
            }
        } else {
            add(new Book(id, title, description));
        }
    }

    public void delete(int id) {
        Book book = getBook(id);
        if (book != null) {
            bookStoreRepository.delete(book);
        }
    }
}
