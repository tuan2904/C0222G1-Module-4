package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
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
    bookRepository.returnBook(number,id);
    }

    @Override
    public Book findId(int id) {
        return bookRepository.findAllByIdBook(id);
    }


}
