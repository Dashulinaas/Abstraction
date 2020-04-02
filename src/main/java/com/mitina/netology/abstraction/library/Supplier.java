package com.mitina.netology.abstraction.library;

import java.util.List;

public interface Supplier {
    List<Library.Book> getBooks(String name, int count);
}
