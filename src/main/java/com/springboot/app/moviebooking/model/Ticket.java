package com.springboot.app.moviebooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TICKET")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer room;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "showtime_id")
    private ShowTime showTime;

}
