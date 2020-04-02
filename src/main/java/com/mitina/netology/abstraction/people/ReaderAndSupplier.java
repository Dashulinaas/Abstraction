package com.mitina.netology.abstraction.people;

import com.mitina.netology.abstraction.library.Library;
import com.mitina.netology.abstraction.library.Library.Book;
import com.mitina.netology.abstraction.library.Reader;
import com.mitina.netology.abstraction.library.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReaderAndSupplier implements Reader, Supplier {
    private static final Random RANDOM = new Random();

    //  Ближайшая к дому
    Library library;
    Book bookInRead;

    public ReaderAndSupplier(Library library) {
        this.library = library;
    }

    @Override
    public void receiveBook(String bookName) {
        System.out.println("ЧИТАТЕЛЬ: Здравствуйте, я хотел бы получить книгу: \"" + bookName + "\"");
        Book book = library.getAdministrator().askBook(bookName);
        System.out.println((book == null) ? "ЧИТАТЕЛЬ: Жаль, что у вас нет этой книги" : "ЧИТАТЕЛЬ: Спасибо за книгу! Верну в срок!");
    }

    @Override
    public Book returnBook() {
        System.out.println("ЧИТАТЕЛЬ: Ладно, вот ваша книга");
        return bookInRead;
    }

    @Override
    public List<Book> getBooks(String name, int count) {
        System.out.println("ПОСТАВЩИК: Вот это заявочка, попробуем исполнить...");
        List<Book> books = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            books.add(getBookWithName(name));
        }

        System.out.println("ПОСТАВЩИК: Держите ваш заказ!");
        return books;
    }

    private static Book getBookWithName(String name) {
        return new Book(RANDOM.nextInt(), name);
    }
}
