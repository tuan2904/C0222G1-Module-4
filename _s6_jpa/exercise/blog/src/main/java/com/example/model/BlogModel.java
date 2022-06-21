package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "blog_table")
public class BlogModel {
    @Id

    @Column(name = "id_blog", columnDefinition = "INT")
    private int idBlog;
    @Column(name = "title_blog", columnDefinition = "VARCHAR(200)")
    private String titleBlog;
    @Column(name = "content_blog", columnDefinition = "VARCHAR(2000)")
    private String contentBlog;

    public BlogModel() {
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitleBlog() {
        return titleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        this.titleBlog = titleBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }
}
