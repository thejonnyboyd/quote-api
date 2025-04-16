package com.thejonnyboyd.quoteapi.repository;

import com.thejonnyboyd.quoteapi.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
