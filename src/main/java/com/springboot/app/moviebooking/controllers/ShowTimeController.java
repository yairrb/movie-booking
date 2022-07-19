package com.springboot.app.moviebooking.controllers;

import com.springboot.app.moviebooking.model.ShowTime;
import com.springboot.app.moviebooking.services.ShowTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/showtime")
public class ShowTimeController {

    private final ShowTimeService showTimeService;

    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }


    @GetMapping(value = "/{movieId}", produces = "application/json")
    public ResponseEntity<List<ShowTime>> getAll(@RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer size, @PathVariable Long movieId) {

        return ResponseEntity.ok(showTimeService.getAllShowTimes(page, size, movieId));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ShowTime>> getAllAvailable(@RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer size) {

        return ResponseEntity.ok(showTimeService.getAllShowTimes(page, size));
    }

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ShowTime> createShowTime(@RequestBody ShowTime showTime) {
        return ResponseEntity.ok(showTimeService.create(showTime));
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ShowTime> updateShowTime(@PathVariable Long id, @RequestBody ShowTime showTime) {
        return ResponseEntity.ok(showTimeService.update(id, showTime));
    }

}
