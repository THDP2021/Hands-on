package com.thd.springapi.APIPractice.Controller;

import com.thd.springapi.APIPractice.Model.Book;
import com.thd.springapi.APIPractice.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/api/Books")
    public List<Book> getTopBooks() throws Exception {
        return bookService.getTopBooks();
    }
}