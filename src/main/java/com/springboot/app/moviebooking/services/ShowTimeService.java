package com.springboot.app.moviebooking.services;

import com.springboot.app.moviebooking.model.ShowTime;

import java.util.List;

public interface ShowTimeService {

    List<ShowTime> getAllShowTimes(Integer pageNumber, Integer pageSize, Long movieId);

    List<ShowTime> getAllShowTimes(Integer pageNumber, Integer pageSize);

    ShowTime getShowTime(Long id);

    ShowTime create(ShowTime showTime);

    ShowTime update(Long id, ShowTime showTime);

    void delete(Long id);
}
