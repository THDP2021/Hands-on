package com.thd.springapi.APIPractice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    // This is a basic controller,
    // TODO: Create a new route, returning the list of the retrieved books from the New York Times public API.
    // Also remember to inject the BookService and use the appropriate annotations

    @GetMapping("/")
    public String welcome(){
        return "THD Hands-on welcome route.";
    }
}