package codegym.vn.service.impl;

import codegym.vn.entity.Blog;
import codegym.vn.repository.BlogRepository;
import codegym.vn.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository repository;
    @Override
    public boolean create(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Blog> findAllByTitle(String title) {
        return repository.findAllByTitleContaining(title);
    }

    @Override
    public Page<Blog> findAllAndPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Blog> findAllSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
