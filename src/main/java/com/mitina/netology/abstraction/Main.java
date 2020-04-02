package com.mitina.netology.abstraction;

import com.mitina.netology.abstraction.library.Library;
import com.mitina.netology.abstraction.people.AdminMiniLibrary;
import com.mitina.netology.abstraction.people.ReaderAndSupplier;

class Main {
    public static final String POPULAR_BOOK_NAME = "Гарри Поттер и тайны Мадридского двора";

    public static void main(String[] args) {

        //  Сначала бог создал библиотеку
        Library library = new Library();

        //  Создаем человека-оркестра, работника библиотеки на все руки
        AdminMiniLibrary libraryWorker = new AdminMiniLibrary(library);

        //  Создаем клиента и поставщика
        ReaderAndSupplier readerAndSupplier = new ReaderAndSupplier(library);

        //  Книг в библиотеке нет, надо заказать
        libraryWorker.orderBook(readerAndSupplier, POPULAR_BOOK_NAME, 5);

        //  Читатель получает книгу
        readerAndSupplier.receiveBook(POPULAR_BOOK_NAME);

        //  Администратор устал ждать и отобрал книгу у читателя,
        //  применяя телесные наказания и вернул книгу в библиотеку
        libraryWorker.overdueNotification(readerAndSupplier);

    }
}