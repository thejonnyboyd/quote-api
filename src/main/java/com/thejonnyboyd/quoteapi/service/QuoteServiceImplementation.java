package com.thejonnyboyd.quoteapi.service;

import com.thejonnyboyd.quoteapi.model.Quote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImplementation {

    private final QuoteRepository quoteRepository;
    private final Random random = new Random();

    public QuoteServiceImplementation(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    @Override
    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteById(Long id){
        return quoteRepository.findById(id)
                .orElseThrow(()-> new QuoteNotFoundException("Quote not found with ID " + id));
    }

    @Override
    public Quote getRandomQuote(){
        List<Quote> quotes = quoteRepository.findAll();
        if(quotes.isEmpty()){
            throw new QuoteNotFoundException("No quotes available");
        }
        return quotes.get(random.nextInt(quotes.size()));
    }

    @Override
    public Quote createQuote(Quote quote){
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Long id, Quote updatedQuote){
        Quote existing = getQuoteById(id);
        existing.setText(updatedQuote.getText());
        existing.setAuthor(updatedQuote.getAuthor());
        return quoteRepository.save(existing);
    }

    @Override
    public void deleteQuote(Long id){
        quoteRepository.deleteById(id);
    }

}
