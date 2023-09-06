package com.waracle.cakemgr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.model.Cake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CakeControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void cakes() throws Exception {
        mockMvc.perform(get("/cakes"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Lemon cheesecake")))
                .andExpect(content().string(containsString("victoria sponge")))
                .andExpect(content().string(containsString("Carrot cake")))
                .andExpect(content().string(containsString("Banana cake")))
                .andExpect(content().string(containsString("Birthday cake")));
    }

    @Test
    public void cake_found() throws Exception {
        mockMvc.perform(get("/cake/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Lemon cheesecake")));
    }

    @Test
    public void cake_notFound() throws Exception {
        mockMvc.perform(get("/cake/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Could not find cake with id 100")));
    }

    @Test
    public void newCake() throws Exception {
        Cake newCake = new Cake("Rocky Road", "A Rocky Road description", "A Rocky Road image");

        mockMvc.perform(post("/cake")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCake)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Rocky Road")));
    }

    @Test
    public void updateCake_exists() throws Exception {
        Cake newCake = new Cake("Birthday cake", "a yearly treat", "A different birthday cake image");

        mockMvc.perform(put("/cake/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCake)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("A different birthday cake image")));
    }

    @Test
    public void updateCake_doesNotExist() throws Exception {
        Cake newCake = new Cake("Birthday cake", "a yearly treat", "A different birthday cake image");

        mockMvc.perform(put("/cake/100")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCake)))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Could not find cake with id 100")));
    }

    @Test
    public void deleteCake() throws Exception {
        mockMvc.perform(delete("/cake/5"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/cake/5"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Could not find cake with id 5")));
    }

}
