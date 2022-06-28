package com.example.book.model;

import javax.persistence.*;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    @Column(columnDefinition = "VARCHAR(200)")
    private String codeBook;
    @Column(columnDefinition = "VARCHAR(200)")
    private String nameBook;
    @Column(columnDefinition = "VARCHAR(200)")
    private String authorBook;
    @Column(columnDefinition = "VARCHAR(200)")
    private String publicationDate;
    @Column(columnDefinition = "VARCHAR(200)")
    private int numberOfBooks;
    @ManyToOne
    @JoinColumn(name = "id")
    private BorrowBooks borrowBooks;

    public Book() {
    }

    public BorrowBooks getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(BorrowBooks borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public Book(int idBook,
                String codeBook,
                String nameBook,
                String authorBook,
                String publicationDate,
                int numberOfBooks) {
        this.idBook = idBook;
        this.codeBook = codeBook;
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.publicationDate = publicationDate;
        this.numberOfBooks = numberOfBooks;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
