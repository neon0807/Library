package com.skypro.library.controller;

import com.skypro.library.entity.Book;
import com.skypro.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class SpringMVCController {
    private BookService bookService;

    public SpringMVCController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/web")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.readAll());
        return "dashboard";
    }
}
