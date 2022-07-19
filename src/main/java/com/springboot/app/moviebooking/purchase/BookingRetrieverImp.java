package com.springboot.app.moviebooking.purchase;

import com.springboot.app.moviebooking.model.Ticket;
import com.springboot.app.moviebooking.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingRetrieverImp implements BookingRetriever {

    private final TicketService ticketService;

    @Override
    public Ticket purchaseTicket(Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @Override
    public List<Ticket> purchaseCollection(List<Ticket> tickets) {
        return ticketService.creatAll(tickets);
    }

    @Override
    public List<Ticket> getCustomerTickets(Long userId) {
        return ticketService.getAllTickets(userId);
    }
}
