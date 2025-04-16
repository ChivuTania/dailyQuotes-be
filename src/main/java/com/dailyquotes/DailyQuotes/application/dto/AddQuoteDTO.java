package com.dailyquotes.DailyQuotes.application.dto;

public class AddQuoteDTO {

    private String name;
    private String author;
    private boolean posted;

    public AddQuoteDTO(String name, String author, boolean posted) {
        this.name = name;
        this.author = author;
        this.posted = posted;
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
