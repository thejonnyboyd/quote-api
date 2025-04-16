package com.thejonnyboyd.quoteapi.model;

public class Quote {

    private String text;
    private String author;

    public Quote(String text, String author){
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

}
