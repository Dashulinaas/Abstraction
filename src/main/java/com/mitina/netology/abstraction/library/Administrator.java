package com.mitina.netology.abstraction.library;

import com.mitina.netology.abstraction.library.Library.Book;

public interface Administrator {
    void overdueNotification(Reader reader);
    Book askBook(String name);
}
