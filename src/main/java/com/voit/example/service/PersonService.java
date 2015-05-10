package com.voit.example.service;

import com.voit.example.entity.Person;
import com.voit.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * Service to handle operations on <code>Person</code>.
 *
 * @author mark voit
 */
@Service
public class PersonService {

    private static Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;


    /**
     * Saves the person to database.
     *
     * @param person
     * @return
     */
    @Transactional
    public Person savePerson(Person person) {
        LOGGER.debug("savePerson has been called");
        if (StringUtils.isEmpty(person.getEmail())) {
            throw new IllegalArgumentException("");
        }
        return personRepository.save(person);
    }

    /**
     * Find person by id.
     *
     * @param id
     * @return single person
     */
    public Person findById(Long id) {
        LOGGER.debug("findById has been called");
        return personRepository.findOne(id);
    }

    /**
     * Returns list of persons based on search parameters.
     *
     * @param q
     * @param field field can be email, name or all
     * @return
     */
    public Page<Person> search(String q, String field, Pageable pageable) {
        LOGGER.debug("Search has been called q="+q);

        if ("*".equals(q) || "all".equals(field)) {
            return personRepository.findAll(pageable);
        }
        else if ("email".equals(field)) {
            final Person p = personRepository.findByEmailAddress(q);
            return new PageImpl(Arrays.asList(p), pageable, 1);
        }
        else {
            return personRepository.findByName(q, pageable);
        }
    }

}
