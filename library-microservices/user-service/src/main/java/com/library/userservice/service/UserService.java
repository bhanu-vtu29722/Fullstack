package com.library.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.library.userservice.repository.UserRepository;
import com.library.userservice.entity.User;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
