package com.springboot.app.moviebooking.repositories;

import com.springboot.app.moviebooking.model.ShowTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {

    @Query("select s from ShowTime s where s.movie.id = :movie")
    Page<ShowTime> findAllByMovie(Long movie, Pageable pageable);

    Page<ShowTime> findAllByRoom(Integer room, Pageable pageable);

}
