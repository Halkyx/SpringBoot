package com.tiki.bookstore.repository;

import com.tiki.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public class BookStoreRepository extends StoreRepository<Book> {

    public BookStoreRepository() {
        collections.add(new Book(1, "Không Gia Đình", "Chú bé Remi lang thang theo gánh xiếc của bác Vitaly"));
        collections.add(new Book(2, "Cuốn theo chiều gió", "Nội chiến Hoa kỳ, cuộc tình giữa Red Butler và Ohara"));
        collections.add(new Book(3, "Mắt Biếc", "Cô giáo Hồng xinh"));
    }

    @Override
    public List<Book> getAll() {
        return collections;
    }

    @Override
    public Optional<Book> get(int id) {

        Book bookById = collections.stream()
                .filter(book -> id == book.getId())
                .findAny()
                .orElse(null);

        return Optional.ofNullable(bookById);
    }

    @Override
    public void add(Book book) {
        collections.add(book);
    }

    @Override
    public void update(Book book) {
    }

    @Override
    public void deleteByID(int id) {
//        collections.remove(id - 1);
    }

    @Override
    public void delete(Book book) {
        collections.remove(book);
    }
}
