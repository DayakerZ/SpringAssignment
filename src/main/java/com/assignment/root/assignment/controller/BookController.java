package com.assignment.root.assignment.controller;

import com.assignment.root.assignment.entity.Book;
import com.assignment.root.assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/booksList")
    public String getAllBooks(Model theModel) {

        List<Book> books = bookService.findAll();

        theModel.addAttribute("books",books);

        return "/books/books-collection";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Book book = new Book();

        theModel.addAttribute("book", book);

        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("book") Book book) {

        bookService.save(book);

        return "redirect:/library/booksList";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {

        bookService.deleteById(theId);

        return "redirect:/library/booksList";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId,
                                    Model theModel) {

        Book book = bookService.findById(theId);

        theModel.addAttribute("book", book);

        return "books/book-form";
    }
}
