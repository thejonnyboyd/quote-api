package com.thejonnyboyd.quoteapi.service;

import com.thejonnyboyd.quoteapi.exception.QuoteNotFoundException;
import com.thejonnyboyd.quoteapi.model.Quote;
import com.thejonnyboyd.quoteapi.repository.QuoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuoteImplementationTest {

    private QuoteRepository quoteRepository;
    private QuoteServiceImplementation quoteService;

    @BeforeEach
    void setUp(){
        quoteRepository = mock(QuoteRepository.class);
        quoteService = new QuoteServiceImplementation(quoteRepository);
    }

    @Test
    void testGetAllQuotes(){
        List<Quote> mockQuotes = Arrays.asList(
                new Quote("Quote 1", "Author A"),
                new Quote("Quote 2", "Author B")
        );

        when(quoteRepository.findAll()).thenReturn(mockQuotes);

        List<Quote> result = quoteService.getAllQuotes();

        assertEquals(2, result.size());
        assertEquals("Quote 1", result.get(0).getText());
        verify(quoteRepository, times(1)).findAll();
    }

    @Test
    void testGetQuoteByIdSuccessful(){
        Quote quote = new Quote("Test Quote", "Author");
        quote.setId(1L);

        when(quoteRepository.findById(1L)).thenReturn(Optional.of(quote));

        Quote result = quoteService.getQuoteById(1L);

        assertEquals("Test Quote", result.getText());
        verify(quoteRepository, times(1)).findById(1L);
    }

    @Test
    void testGetRandomQuoteSuccessful(){
        List<Quote> quotes = Arrays.asList(
                new Quote("Quote 1", "Author A"),
                new Quote("Quote 2", "Author B"),
                new Quote("Quote 3", "Author C")
        );

        when(quoteRepository.findAll()).thenReturn(quotes);

        Quote result = quoteService.getRandomQuote();

        assertNotNull(result);
        assertTrue(quotes.contains(result));
        verify(quoteRepository, times(1)).findAll();
    }

    @Test
    void testCreateQuote(){
        Quote quote = new Quote("Quote 1", "Author A");
        when(quoteRepository.save(quote)).thenReturn(quote);

        Quote result = quoteService.createQuote(quote);

        assertEquals("Quote 1", result.getText());
        verify(quoteRepository, times(1)).save(quote);
    }

    @Test
    void testUpdateQuote(){
        Quote existing = new Quote("Quote 1", "Author A");
        existing.setId(1L);

        Quote updated = new Quote("Quote 1 Updated", "Author A Updated");

        when(quoteRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(quoteRepository.save(existing)).thenReturn(existing);

        Quote result = quoteService.updateQuote(1L, updated);

        assertEquals("Quote 1 Updated", result.getText());
        assertEquals("Author A Updated", result.getAuthor());
        verify(quoteRepository).save(existing);
    }

    @Test
    void testDeleteQuoteSuccessful(){
        when(quoteRepository.existsById(1L)).thenReturn(true);

        quoteService.deleteQuote(1L);

        verify(quoteRepository).deleteById(1L);
    }

}
