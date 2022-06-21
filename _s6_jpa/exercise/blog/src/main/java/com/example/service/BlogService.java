package com.example.service;

import com.example.model.BlogModel;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogModel> listBlog() {
        return blogRepository.findAllBlogModel();
    }

    @Override
    public void create(int idBlog, String titleBlog, String contentBlog) {
        blogRepository.insertBlog(idBlog, titleBlog, contentBlog);
    }

    @Override
    public void remove(int idBlog) {
        blogRepository.deleteBlog(idBlog);
    }

    @Override
    public List<BlogModel> listContent(int idBlog) {
        return blogRepository.findAllByContentBlog(idBlog);
    }

    @Override
    public void update(BlogModel blogModel) {
        blogRepository.editBlog(blogModel.getIdBlog(), blogModel.getTitleBlog(), blogModel.getContentBlog());
    }

    @Override
    public BlogModel findById(int id) {
        return blogRepository.findAllByIdBlog(id);
    }

}
