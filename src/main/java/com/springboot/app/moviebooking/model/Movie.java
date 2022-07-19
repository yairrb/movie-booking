package com.springboot.app.moviebooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.Date;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String Genre;

    @Column(name = "YEAR_OF_PRODUCTION")
    @Temporal(TemporalType.DATE)
    private Date yearOfProduction;

    private Double duration;

    private boolean enable;
}
