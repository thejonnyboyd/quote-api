package com.thejonnyboyd.quoteapi;

import com.thejonnyboyd.quoteapi.model.Quote;
import com.thejonnyboyd.quoteapi.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuoteDataLoader implements CommandLineRunner {

    private final QuoteRepository quoteRepository;

    public QuoteDataLoader(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (quoteRepository.count() == 0) {
            quoteRepository.save(new Quote("Success is not final, failure is not fatal: It is the courage to continue that counts.", "Winston Churchill"));
            quoteRepository.save(new Quote("You do not rise to the level of your goals. You fall to the level of your systems.", "James Clear"));
            quoteRepository.save(new Quote("The only way to do great work is to love what you do.", "Steve Jobs"));
            quoteRepository.save(new Quote("Do the best you can until you know better. Then when you know better, do better.", "Maya Angelou"));
            quoteRepository.save(new Quote("You are in danger of living a life so comfortable and soft, that you will die without ever realizing your true potential.", "David Goggins"));
            quoteRepository.save(new Quote("It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.", "Seneca"));
            System.out.println("Seeded quotes successfully");
        } else {
            System.out.println("Skipped seeding quotes");
        }
    }

}
