package com.dailyquotes.DailyQuotes.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Quote {

    @Id
    private String id;
    private String name;
    private String author;
    private boolean posted;

    public Quote(String id, String name, String author, boolean posted) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.posted = posted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }
}

