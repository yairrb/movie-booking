package com.springboot.app.moviebooking.purchase;

import com.springboot.app.moviebooking.model.Ticket;

import java.util.List;

public interface BookingRetriever {

    Ticket purchaseTicket(Ticket ticket);

    List<Ticket> purchaseCollection(List<Ticket> tickets);

    List<Ticket> getCustomerTickets(Long userId);
}
