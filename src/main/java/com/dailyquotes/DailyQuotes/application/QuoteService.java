package com.dailyquotes.DailyQuotes.application;

import com.dailyquotes.DailyQuotes.application.dto.AddQuoteDTO;
import com.dailyquotes.DailyQuotes.domain.Quote;
import com.dailyquotes.DailyQuotes.domain.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Quote getRandomQuote(List<Quote> quotes){
        List<Quote> notPosted = new ArrayList<>();

        for (Quote quote : quotes){
            if (!quote.isPosted()){
                notPosted.add(quote);
            }
        }

        if (notPosted.isEmpty()){
            for (Quote quote : quotes){
                quote.setPosted(false);
                this.quoteRepository.save(quote);
                notPosted.add(quote);
            }
        }

        Random random = new Random();
        int index = random.nextInt(notPosted.size());

        Quote randomQuote = notPosted.get(index);

        randomQuote.setPosted(true);
        this.quoteRepository.save(randomQuote);

        return notPosted.get(index);
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
