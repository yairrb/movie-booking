package com.springboot.app.moviebooking.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "MB_ROL")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private String name;

    @OneToMany(targetEntity = UserDB.class, mappedBy = "role",
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserDB> users;


}
