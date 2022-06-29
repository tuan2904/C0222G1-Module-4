package com.example.restfulblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    @Column(name = "name_category", columnDefinition = "VARCHAR(200)")
    private String nameCategory;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<BlogModel> blogModels;

    public Category() {
    }

    public Set<BlogModel> getBlogModels() {
        return blogModels;
    }

    public void setBlogModels(Set<BlogModel> blogModels) {
        this.blogModels = blogModels;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
