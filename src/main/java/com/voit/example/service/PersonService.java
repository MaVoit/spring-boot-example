package com.voit.example.service;

import com.voit.example.entity.Person;
import com.voit.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mark voit
 */
@Service
public class PersonService {

    private static Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;


    /**
     * Saves to person to database.
     *
     * @param person
     * @return
     */
    public Long savePerson(Person person) {
        LOGGER.debug("savePerson has been called");
        return personRepository.save(person).getId();
    }
}
