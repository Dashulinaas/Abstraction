package com.mitina.netology.abstraction.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books = new ArrayList<>();
    Administrator administrator;

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookForName(String name) {
        return books.stream()
                .filter(book -> book.name.equals(name))
                .findAny()
                .orElse(null);
    }

    public void returnBook(Book book) {
        books.add(book);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public static class Book {
        private final int id;
        private final String name;

        public Book(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
