package org.planet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.planet.models.dto.PlanetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private PlanetDTO planet;
    private final String URL = "/api/v1/planet/";

    @BeforeEach
    public void setUp() {
        planet = new PlanetDTO();
        planet.setId(1L);
        planet.setName("someName");
    }

    @Test
    void addNewPlanet() throws Exception {
        String valueAsString = objectMapper.writeValueAsString(planet);
        ResultActions resultActions = mockMvc.perform(post(URL + "new")
                .contentType(APPLICATION_JSON)
                .content(valueAsString)
        ).andExpect(status().isOk());

        assertThat(resultActions.andReturn().getResponse()).isNotNull();
    }

    @Test
    void setNewLord() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("planet_id", "1");
        params.add("lord_id", "1");
        ResultActions resultActions = mockMvc.perform(patch(URL + "set_lord")
                .params(params)
                .contentType(APPLICATION_JSON)
        ).andExpect(status().isOk());

        assertThat(resultActions.andReturn().getResponse()).isNotNull();
    }

    @Test
    void destroy() throws Exception {
        mockMvc.perform(delete(URL + "destroy").param("id", "1")).andExpect(status().isOk());
    }
}