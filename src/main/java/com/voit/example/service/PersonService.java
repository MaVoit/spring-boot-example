package com.voit.example.service;

import com.voit.example.model.Person;
import com.voit.example.jpa.PersonRepository;
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
import java.util.Optional;

/**
 * Service to handle operations on <code>Person</code>.
 *
 * @author mark voit
 */
@Service
public class PersonService {

    private final Logger log = LoggerFactory.getLogger(getClass().getName());

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
        log.debug("savePerson has been called");
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
    public Optional<Person> findById(String id) {
        log.debug("findById has been called");
        return personRepository.findById(id);
    }

    /**
     * Returns list of persons based on search parameters.
     *
     * @param q
     * @param field field can be email, name or all
     * @return
     */
    public Page<Person> search(String q, String field, Pageable pageable) {
        log.debug("Search has been called q="+q);

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
