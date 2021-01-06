package com.everis.microserviciopersons.models.dao;

import com.everis.microserviciopersons.models.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends JpaRepository<Person, Long> {
    Person findByDocument(String document);
}
