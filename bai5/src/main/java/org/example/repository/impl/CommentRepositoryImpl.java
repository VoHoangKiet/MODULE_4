package org.example.repository.impl;

import org.example.entity.Comment;
import org.example.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    public CommentRepositoryImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean create(Comment comment) {
        entityManager.persist(comment);
        return true;
    }

    @Override
    public boolean update(Comment comment) {
        entityManager.merge(comment);
        return true;
    }

    @Override
    public Comment findById(int id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("From Comment ").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}
