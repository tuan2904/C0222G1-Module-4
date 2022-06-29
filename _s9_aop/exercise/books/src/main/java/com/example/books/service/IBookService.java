package com.example.books.service;


import com.example.books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> listBook();
    void returnBook(int number,int id);
    Book findId(int id);
    public void save(Book book);

}
