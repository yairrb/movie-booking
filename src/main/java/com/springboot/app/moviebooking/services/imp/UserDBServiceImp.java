package com.springboot.app.moviebooking.services.imp;

import com.springboot.app.moviebooking.model.UserDB;
import com.springboot.app.moviebooking.repositories.UserDBRepository;
import com.springboot.app.moviebooking.services.UserService;
import org.springframework.stereotype.Service;

import java.io.PushbackReader;

@Service
public class UserDBServiceImp implements UserService {

    private final UserDBRepository repository;

    public UserDBServiceImp(UserDBRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDB createUser(UserDB user) {
        return this.repository.save(user);
    }

    @Override
    public UserDB updateUser(UserDB user) {
        return this.repository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public UserDB getUser(Long id) {
        return this.repository.findById(id).orElseThrow();
    }
}
