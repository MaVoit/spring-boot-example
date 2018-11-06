package com.voit.example.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PersonController personController;

    @Test
    public void testMe() throws Exception {
        log.info("HALLO CONTROLLER TEST");
        assertThat(personController).isNotNull();

        this.mockMvc.perform(get("/").accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
