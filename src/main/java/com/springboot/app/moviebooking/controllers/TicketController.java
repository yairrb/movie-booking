package com.springboot.app.moviebooking.controllers;

import com.springboot.app.moviebooking.model.Ticket;
import com.springboot.app.moviebooking.purchase.BookingRetriever;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class TicketController {

    private BookingRetriever retriever;

    public TicketController(BookingRetriever retriever) {
        this.retriever = retriever;
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Ticket>> createAllTickets(@RequestBody List<Ticket> tickets) {
        return ResponseEntity.ok(retriever.purchaseCollection(tickets));
    }

    @GetMapping(value = "/{userid}", produces = "application/json")
    public ResponseEntity<List<Ticket>> getTickets(@PathVariable Long userid) {
        return ResponseEntity.ok(retriever.getCustomerTickets(userid));
    }


}
