package com.example.book.repository;

import com.example.book.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBorrowBooksRepository extends JpaRepository<BorrowBooks,Integer> {
    @Query(value="select * from borrow_books where id=:id",nativeQuery = true)
    BorrowBooks codeBorrowBooks(@Param("id") int id);
}
