package codegym.vn.service;

import codegym.vn.entity.Blog;

import java.util.List;

public interface BlogService extends Service<Blog> {
    List<Blog> findAllByAuthor(String author);
}
