package com.springboot.app.moviebooking.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieCatalogueControllerMvcTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void TestController() throws Exception {
        mvc.perform(get("/api/movies")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
