package org.planet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.planet.models.dto.LordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LordControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private LordDTO lord;
    private final String URL = "/api/v1/lord/";

    @BeforeEach
    public void setUp() {
        lord = new LordDTO();
        lord.setId(1L);
        lord.setAge(25);
        lord.setName("someName");
    }

    @Test
    void addNewLord() throws Exception {
        String valueAsString = objectMapper.writeValueAsString(lord);
        ResultActions resultActions = mockMvc.perform(post(URL + "new")
                .contentType(APPLICATION_JSON)
                .content(valueAsString)
        ).andExpect(status().isOk());

        assertThat(resultActions.andReturn().getResponse()).isNotNull();
    }

    @Test
    void lazyLords() throws Exception {
        mockMvc.perform(get(URL + "lazy")).andExpect(status().isOk());
    }

    @Test
    void topLords() throws Exception {
        mockMvc.perform(get(URL + "top")).andExpect(status().isOk());
    }
}