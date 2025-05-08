package com.dailyquotes.DailyQuotes.interfaces;

import com.dailyquotes.DailyQuotes.application.QuoteService;
import com.dailyquotes.DailyQuotes.application.dto.AddQuoteDTO;
import com.dailyquotes.DailyQuotes.domain.Quote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://dailyquote-fe-web-caevdpcac9h6f2hj.westeurope-01.azurewebsites.net")
@RestController
public class QuoteRestController {
    private QuoteService quoteService;

    public QuoteRestController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes(){
        return ResponseEntity.ok(this.quoteService.getAllQuotes());
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteById(final @PathVariable String id){
        return ResponseEntity.ok(this.quoteService.getQuoteById(id));
    }

    @PostMapping("/quotes")
    public ResponseEntity<Void> addQuote(final @RequestBody AddQuoteDTO dto){
        this.quoteService.addQuote(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/quotes/random")
    public ResponseEntity<Quote> getRandomQuote(){
        List<Quote> allQuotes = this.quoteService.getAllQuotes();
        return ResponseEntity.ok(this.quoteService.getRandomQuote(allQuotes));
    }
}
