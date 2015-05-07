package com.voit.example.web;

import com.voit.example.entity.Person;
import com.voit.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mark voit
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/save")
    public String save() {
        personService.savePerson(new Person("mark", "test"));
        return "saved person!";
    }
}
