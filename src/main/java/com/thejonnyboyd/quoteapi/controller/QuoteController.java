package com.thejonnyboyd.quoteapi.controller;

import com.thejonnyboyd.quoteapi.model.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    @GetMapping("/random")
    public Quote getRandomQuote(){
        return new Quote("Stay hungry, stay foolish", "Steve Jobs");
    }

}
