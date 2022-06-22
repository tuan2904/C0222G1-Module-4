package com.example.blog.repository;

import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Modifying
    @Query(value = "delete from category where id_category=:id_category", nativeQuery = true)
    void deleteCategory(@Param("id_category") int idCategory);
}
