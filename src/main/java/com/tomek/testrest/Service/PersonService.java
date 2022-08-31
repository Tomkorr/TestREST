package com.tomek.testrest.Service;

import com.tomek.testrest.Model.Person;
import com.tomek.testrest.Repoistory.PersonRepoistory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service

public class PersonService {

    private final PersonRepoistory personRepoistory;

    public PersonService(PersonRepoistory personRepoistory) {
        this.personRepoistory = personRepoistory;
    }
    public Person updatePersonFirstNameById(Long id, Person person){

        Person personToUpdate = personRepoistory.findById(id).orElseThrow();
        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personRepoistory.save(personToUpdate);

        return personToUpdate;
    }

    public Person createPerson(Person person) {
        return personRepoistory.save(person);
    }
}
