package com.tomek.testrest.controller;

import com.tomek.testrest.Model.Person;
import com.tomek.testrest.Repoistory.PersonRepoistory;
import com.tomek.testrest.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class TestAPI {


    @Autowired
    PersonRepoistory personRepoistory;

    @Autowired
    PersonService personService;


    @Transactional
    @PostMapping(value = "/person")
    public String addPerson(@RequestBody Person person) {

        personService.createPerson(person);
        personRepoistory.save(person);

        return "addPersonSuccessfull";
    }

    @GetMapping(value = "/person")
    public List<Person> getPerson() {

        RestTemplate restTemplate = new RestTemplate();

//        How to get persons from other REST app
//        ResponseEntity<Person[]> responseEntity = restTemplate.exchange("localhost:9079/person",
//                HttpMethod.GET,
//                null,
//                Person[].class);
//
//        Stream.of(responseEntity.getBody()).forEach(System.out::println);

        List<Person> persons = personRepoistory.findAll();
        return persons;
    }

    @DeleteMapping(value = "/person/{id}")
    public String deletePersonById(@PathVariable Integer id) {
        personRepoistory.deletePersonById(id);
        return "Remove person successfully";
    }

    @PutMapping(value = "/person/{id}")
    public String updatePerson(@PathVariable Long id, @RequestBody Person person/*@PathVariable Long id, @PathVariable String firstName*/) {

        personService.updatePersonFirstNameById(id, person);
        return "Update person successfully";
    }


}
