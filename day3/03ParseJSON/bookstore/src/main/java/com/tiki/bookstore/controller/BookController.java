package com.tiki.bookstore.controller;

import com.tiki.bookstore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class BookController {
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("books", bookStoreRepository.getAll());
        return "allbooks";
    }


}
