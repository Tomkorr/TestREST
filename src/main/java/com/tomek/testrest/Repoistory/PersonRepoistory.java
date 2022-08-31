package com.tomek.testrest.Repoistory;

import com.tomek.testrest.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PersonRepoistory extends JpaRepository<Person, Long> {

    @Modifying
    @Query(value = "insert into person(first_name, last_name) values(?1, ?2)", nativeQuery = true)
    Integer addPerson(String name, String lastName);

    @Modifying
    @Query(value = "delete from person where id = ?1", nativeQuery = true)
    Integer deletePersonById(Integer id);

    List<Person> findAll();

    @Query(value = "select * from person where first_name = ?1", nativeQuery = true)
    Person findByFirstName(String name);

}
