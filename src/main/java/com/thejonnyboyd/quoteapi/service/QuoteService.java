package com.thejonnyboyd.quoteapi.service;

import com.thejonnyboyd.quoteapi.model.Quote;

import java.util.List;

public interface QuoteService {
    List<Quote> getAllQuotes();
    Quote getQuoteById(Long id);
    Quote getRandomQuote();
    Quote createQuote(Quote quote);
    Quote updateQuote(Long id, Quote updatedQuote);
    void deleteQuote(Long id);
}
