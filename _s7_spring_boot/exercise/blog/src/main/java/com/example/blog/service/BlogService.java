package com.example.blog.service;
import com.example.blog.model.BlogModel;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<BlogModel> search(BlogModel blogModel,Pageable pageable) {
        return blogRepository.searchBlog(blogModel.getTitleBlog(),pageable);
    }

    @Override
    public Page<BlogModel> listBlog(Pageable pageable) {
        return blogRepository.findAllBlogModel(pageable);
    }

    @Override
    public void create(BlogModel blogModel) {
        blogRepository.save(blogModel);
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
        blogRepository.editBlog(blogModel.getIdBlog(), blogModel.getTitleBlog(), blogModel.getContentBlog()
        ,blogModel.getDateBlog());
    }

    @Override
    public BlogModel findById(int id) {
        return blogRepository.findAllByIdBlog(id);
    }

}
