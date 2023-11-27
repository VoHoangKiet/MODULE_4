package codegym.vn.service.impl;

import codegym.vn.entity.User;
import codegym.vn.repository.UserRepository;
import codegym.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean create(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
