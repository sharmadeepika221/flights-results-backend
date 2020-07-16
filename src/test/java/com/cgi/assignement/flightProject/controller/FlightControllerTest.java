package com.cgi.assignement.flightProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getFlightResultsTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/api/v1/flightResults").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        assertEquals(result.getResponse().getStatus(),200);

    }

    @Test
    public void getFlightResultsByInvalidUrlTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/flight").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound()).andReturn();
        assertEquals(result.getResponse().getStatus(),404);

    }


}
