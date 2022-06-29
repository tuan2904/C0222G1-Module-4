package com.example.books.model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class BorrowBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int codeBorrowBooks;
    @OneToMany(mappedBy = "borrowBooks")
    private Set<Book> book;

    public int getCodeBorrowBooks() {
        return codeBorrowBooks;
    }

    public void setCodeBorrowBooks(int codeBorrowBooks) {
        this.codeBorrowBooks = codeBorrowBooks;
    }

    public BorrowBooks() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
