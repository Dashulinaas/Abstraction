package com.mitina.netology.abstraction.people;

import com.mitina.netology.abstraction.library.*;
import com.mitina.netology.abstraction.library.Library.Book;

public class AdminMiniLibrary implements Administrator, Librarian {

    //  Место работы
    Library library;

    public AdminMiniLibrary(Library library) {
        this.library = library;
        library.setAdministrator(this);
    }

    @Override
    public void overdueNotification(Reader reader) {

        //  Дает пинка читателю и забирает у него книгу
        System.out.println("АДМИНИСТРАТОР: Так, сколько можно читать? Все сроки уже вышли! Возвращайте книгу!");
        Book book = reader.returnBook();

        //  Возвращает книгу в библиотеку
        System.out.println("АДМИНИСТРАТОР: Хм... Кажется, что эта книга стояла на этой полке...");
        library.returnBook(book);
    }

    @Override
    public Book askBook(String name) {
        System.out.println("АДМИНИСТРАТОР: Интересное название. Давайте искать... А! Вот же она, держите!");
        return library.getBookForName(name);
    }

    @Override
    public void orderBook(Supplier supplier, String name, int count) {
        System.out.println("АДМИНИСТРАТОР: В нашей библиотеке шаром покати. Надо бы заказать "
                + count + " книжек со странным названием " + name);
        //  Заказываем у поставщика книги и засовываем их в библиотеку
        library
                .getBooks()
                .addAll(supplier.getBooks(name, count));
        System.out.println("АДМИНИСТРАТОР: Отлично, спасибо за быструю поставку!");
    }
}
