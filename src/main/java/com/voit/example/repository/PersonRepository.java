package com.voit.example.repository;

import com.voit.example.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mark voit
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
