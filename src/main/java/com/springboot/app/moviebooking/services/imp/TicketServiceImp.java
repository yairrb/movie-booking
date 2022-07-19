package com.springboot.app.moviebooking.services.imp;

import com.springboot.app.moviebooking.model.Ticket;
import com.springboot.app.moviebooking.repositories.TicketRepository;
import com.springboot.app.moviebooking.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImp implements TicketService {

    private final TicketRepository repository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Ticket> creatAll(List<Ticket> tickets) {
        return repository.saveAll(tickets);
    }

    @Override
    public List<Ticket> getAllTickets(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        return repository.findById(ticketId).orElse(Ticket.builder().build());
    }
}
