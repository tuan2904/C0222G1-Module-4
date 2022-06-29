package com.example.restfulblog.model;

import javax.persistence.*;

@Entity(name = "blog_table")
public class BlogModel {
    @Id

    @Column(name = "id_blog", columnDefinition = "INT")
    private int idBlog;
    @Column(name = "title_blog", columnDefinition = "VARCHAR(200)")
    private String titleBlog;
    @Column(name = "content_blog", columnDefinition = "VARCHAR(2000)")
    private String contentBlog;
    @Column(name = "date_blog", columnDefinition = "VARCHAR(200)")
    private String dateBlog;

    @ManyToOne()
    @JoinColumn(name = "id_category")
    private Category category;

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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
