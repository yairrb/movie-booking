package com.springboot.app.moviebooking.services;

import com.springboot.app.moviebooking.model.UserDB;

public interface UserService {

    UserDB createUser(UserDB user);

    UserDB updateUser(UserDB user);

    void deleteUser(Long id);

    UserDB getUser(Long id);
}
