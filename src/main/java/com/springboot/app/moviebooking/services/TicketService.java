package com.springboot.app.moviebooking.services;

import com.springboot.app.moviebooking.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    void deleteTicket(Long id);

    List<Ticket> creatAll(List<Ticket> tickets);

    List<Ticket> getAllTickets(Long userId);

    Ticket getTicket(Long ticketId);
}
