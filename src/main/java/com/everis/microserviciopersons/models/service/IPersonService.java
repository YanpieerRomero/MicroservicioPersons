package com.everis.microserviciopersons.models.service;

import com.everis.microserviciopersons.models.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPersonService {
    Flux<Person> findAll();
    Mono<Person> findById(Long id);
    Mono<Person> findByDocument(String document);
}
