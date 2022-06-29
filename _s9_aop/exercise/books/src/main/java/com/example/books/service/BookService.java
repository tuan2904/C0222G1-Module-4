package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> listBook() {
        return bookRepository.findAll();
    }

    @Override
    public void returnBook(int number,int id) {
        bookRepository.update(id,number);
    }

    @Override
    public Book findId(int id) {
        return null;
    }

    @Override
    public void save(Book book) {
bookRepository.save(book);
    }

}
