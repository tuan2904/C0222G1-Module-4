package com.example.books.repository;


import com.example.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Modifying
    @Query(value="update book set numberOfBooks=:number_of_books+1 where idBook=:id_book",nativeQuery = true)
    void update(@Param("id_book") int id,@Param("number_of_books") int number);
}
