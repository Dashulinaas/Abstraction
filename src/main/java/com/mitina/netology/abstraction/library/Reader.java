package com.mitina.netology.abstraction.library;

import com.mitina.netology.abstraction.library.Library.Book;

public interface Reader {
    void receiveBook(String bookName);
    Book returnBook();
}
