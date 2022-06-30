package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book where id_book=:id_book", nativeQuery = true)
    Book findAllByIdBook(@Param("id_book") int id);

    @Modifying
    @Query(value = "update book set numberOfBooks = :number_of_books+1 where idBook = :id_book")
    void returnBook(@Param("number_of_books") int number, @Param("id_book") int id);

}
