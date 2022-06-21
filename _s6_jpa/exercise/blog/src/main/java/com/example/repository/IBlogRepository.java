package com.example.repository;

import com.example.model.BlogModel;
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
    List<BlogModel> findAllBlogModel();

    @Query(value = "select * from blog_table where id_blog=:id_blog", nativeQuery = true)
    BlogModel findAllByIdBlog(@Param("id_blog") int id);

    @Modifying
    @Query(value = "insert into blog_table value(:idBlog,:titleBlog,:contentBlog)", nativeQuery = true)
    void insertBlog(@Param("idBlog") int idBlog, @Param("titleBlog") String titleBlog, @Param("contentBlog") String contentBlog);

    @Modifying
    @Query(value = "delete from blog_table where id_blog=:id_blog", nativeQuery = true)
    void deleteBlog(@Param("id_blog") int idBlog);

    @Query(value = "select content_blog from blog_table where id_blog=:id_blog", nativeQuery = true)
    List<BlogModel> findAllByContentBlog(@Param("id_blog") int idBlog);


    @Modifying
    @Query(value = "update blog_table set title_blog=:title_blog,content_blog=:content_blog where id_blog=:id_blog", nativeQuery = true)
    void editBlog(@Param("id_blog") int idBlog, @Param("title_blog") String titleBlog, @Param("content_blog") String contentBlog);
}
