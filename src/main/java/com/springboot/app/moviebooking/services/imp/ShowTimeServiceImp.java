package com.springboot.app.moviebooking.services.imp;

import com.springboot.app.moviebooking.model.ShowTime;
import com.springboot.app.moviebooking.repositories.ShowTimeRepository;
import com.springboot.app.moviebooking.services.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImp implements ShowTimeService {

    private final ShowTimeRepository repository;

    @Override
    public List<ShowTime> getAllShowTimes(Integer pageNumber, Integer pageSize, Long movieId) {
        Page<ShowTime> page = repository.findAllByMovie(movieId, PageRequest.of(pageNumber, pageSize));
        return page.getContent();
    }

    @Override
    public List<ShowTime> getAllShowTimes(Integer pageNumber, Integer pageSize) {
        Page<ShowTime> page = repository.findAll(PageRequest.of(pageNumber, pageSize));
        return page.getContent();
    }

    @Override
    public ShowTime getShowTime(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public ShowTime create(ShowTime showTime) {
        return repository.save(showTime);
    }

    @Override
    public ShowTime update(Long id, ShowTime showTime) {
        ShowTime showTime1 = repository.findById(id).orElse(new ShowTime());

        showTime1.setId(showTime.getId());
        showTime1.setMovie(showTime.getMovie());
        showTime1.setRoom(showTime.getRoom());
        showTime1.setStartDate(showTime.getStartDate());

        return repository.save(showTime1);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
