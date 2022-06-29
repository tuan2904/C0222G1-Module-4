package com.example.books.service;


import com.example.books.model.BorrowBooks;

import java.util.List;

public interface IBorrowBooksService {
    void save(BorrowBooks borrowBooks);
    List<BorrowBooks> list();
    BorrowBooks listCode(int code);
    void remove(BorrowBooks borrowBooks);
}
