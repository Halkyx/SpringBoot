package com.tiki.bookstore;

import com.tiki.bookstore.repository.BookStoreRepository;
import com.tiki.bookstore.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookStoreRepository getBookStore() {
        return new BookStoreRepository();
    }

    @Bean
    public BookService getBookService() {
        return new BookService(getBookStore());
    }
}
