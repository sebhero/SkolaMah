/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab20.upg1a;

/**
 * Created by Sebastian Börebäck on 2015-11-10.
 */
public class Book extends Media{



    private String author;

    public Book(long id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public Book() {
        super();
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return this.getTitle()+" skriven av "+author;
    }
}
