package com.dailyquotes.DailyQuotes.application;

import com.dailyquotes.DailyQuotes.application.dto.AddQuoteDTO;
import com.dailyquotes.DailyQuotes.domain.Quote;
import com.dailyquotes.DailyQuotes.domain.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes(){
        return this.quoteRepository.findAll();
    }

    public Quote getQuoteById(String id){
        return this.quoteRepository.findById(id).get();
    }

    public void addQuote(AddQuoteDTO dto){
        Quote quote = new Quote(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getAuthor(),
                dto.isPosted()
        );

        this.quoteRepository.save(quote);
    }
}
