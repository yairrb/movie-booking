package com.springboot.app.moviebooking.repositories;

import com.springboot.app.moviebooking.model.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDBRepository extends JpaRepository<UserDB, Long> {

    UserDB findByEmail(String email);
}
