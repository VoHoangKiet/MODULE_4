package codegym.vn.service.impl;

import codegym.vn.entity.Comment;
import codegym.vn.repository.CommentRepository;
import codegym.vn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public boolean create(Comment comment) {
        commentRepository.save(comment);
        return true;
    }

    @Override
    public boolean update(Comment comment) {
        commentRepository.save(comment);
        return true;
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
