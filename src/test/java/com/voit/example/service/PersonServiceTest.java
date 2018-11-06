package com.voit.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class PersonServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    PersonService personService;

    @Test
    public void testFindById() throws Exception {
        log.info("HALLO TEST");
        assertThat(personService.findById("0000").isPresent()).isFalse();
    }
}
