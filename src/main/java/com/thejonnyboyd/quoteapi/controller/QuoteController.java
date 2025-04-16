package com.thejonnyboyd.quoteapi.controller;

import com.thejonnyboyd.quoteapi.model.Quote;
import com.thejonnyboyd.quoteapi.service.QuoteService;
import com.thejonnyboyd.quoteapi.service.QuoteServiceImplementation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public Quote getRandomQuote(){
        return quoteService.getRandomQuote();
    }

    @GetMapping("/{id}")
    public Quote getQuoteById(@PathVariable Long id){
        return quoteService.getQuoteById(id);
    }

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote){
        return quoteService.createQuote(quote);
    }

    @PutMapping("/{id}")
    public Quote updateQuote(@PathVariable Long id, @RequestBody Quote quote){
        return quoteService.updateQuote(id, quote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id){
        quoteService.deleteQuote(id);
    }

}
