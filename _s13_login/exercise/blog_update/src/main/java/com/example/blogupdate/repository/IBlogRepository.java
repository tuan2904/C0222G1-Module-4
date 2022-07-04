package com.example.blogupdate.repository;


import com.example.blogupdate.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<BlogModel, Integer> {

    @Query(value = "select * from blog_table", nativeQuery = true)
    Page<BlogModel> findAllBlogModel(Pageable pageable);

    @Query(value = "select * from blog_table where id_category=:id_category", nativeQuery = true)
    Page<BlogModel> findBlogModel(Pageable pageable, @Param("id_category") int id);

    @Query(value = "select * from blog_table where id_blog=:id_blog", nativeQuery = true)
    BlogModel findAllByIdBlog(@Param("id_blog") int id);

    @Query(value = "select * from blog_table where id_blog=:id_blog", nativeQuery = true)
    Page<BlogModel> findAllById(@Param("id_blog") int id, Pageable pageable);

    @Modifying
    @Query(value = "insert into blog_table value(:idBlog,:titleBlog,:contentBlog,:dateBlog,:nameCategory)", nativeQuery = true)
    void insertBlog(@Param("idBlog") int idBlog, @Param("titleBlog") String titleBlog, @Param("contentBlog") String contentBlog
            , @Param("dateBlog") String dataBlog, @Param("nameCategory") String nameCategory);

    @Modifying
    @Query(value = "delete from blog_table where id_blog=:id_blog", nativeQuery = true)
    void deleteBlog(@Param("id_blog") int idBlog);

    @Query(value = "select content_blog from blog_table where id_blog=:id_blog", nativeQuery = true)
    List<BlogModel> findAllByContentBlog(@Param("id_blog") int idBlog);

    @Modifying
    @Query(value = "update blog_table set title_blog=:title_blog,content_blog=:content_blog,date_blog=:date_blog where id_blog=:id_blog", nativeQuery = true)
    void editBlog(@Param("title_blog") String titleBlog, @Param("content_blog") String contentBlog,
                  @Param("date_blog") String dateBlog, @Param("id_blog") int idBlog);

    @Query(value = "select * from blog_table where title_blog like :title_blog", nativeQuery = true)
    Page<BlogModel> searchBlog(@Param("title_blog") String title, Pageable pageable);

    @Query(value = "select * from blog_table where title_blog like :title_blog", nativeQuery = true)
    Page<BlogModel> searchName(@Param("title_blog") String title, Pageable pageable);
}
