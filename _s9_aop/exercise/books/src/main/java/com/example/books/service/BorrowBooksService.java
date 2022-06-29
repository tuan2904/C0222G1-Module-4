package com.example.books.service;


import com.example.books.model.BorrowBooks;
import com.example.books.repository.IBorrowBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBooksService implements IBorrowBooksService {
    @Autowired
    private IBorrowBooksRepository borrowBooksRepository;


    @Override
    public void save(BorrowBooks borrowBooks) {
borrowBooksRepository.save(borrowBooks);
    }

    @Override
    public List<BorrowBooks> list() {
        return borrowBooksRepository.findAll();
    }

    @Override
    public BorrowBooks listCode(int id) {
        return borrowBooksRepository.findById(id);
    }

    @Override
    public void remove(BorrowBooks borrowBooks) {

    }
}
