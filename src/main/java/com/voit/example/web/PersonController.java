package com.voit.example.web;

import com.voit.example.entity.Person;
import com.voit.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Controller to handle simple operations on <code>Person</code>.
 *
 * @author mark voit
 */
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    public Person create(@Valid @ModelAttribute Person person) {
        return personService.savePerson(person);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public Optional<Person> findById(@PathVariable final Long id) {
        return personService.findById(id);
    }

    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public Page<Person> search(
            @RequestParam(value = "q", required = true) final String q,
            @RequestParam(value = "field", required = false, defaultValue = "name") final String field,
            Pageable pageable
    ) {
        return personService.search(q, field, pageable);
    }

}
