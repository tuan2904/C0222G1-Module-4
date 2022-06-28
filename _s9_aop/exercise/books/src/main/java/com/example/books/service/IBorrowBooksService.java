package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.model.BorrowBooks;

import java.util.List;

public interface IBorrowBooksService {
    void save(BorrowBooks borrowBooks);
    List<BorrowBooks> list();
    BorrowBooks listCode(int code);
    void remove(BorrowBooks borrowBooks);
}
