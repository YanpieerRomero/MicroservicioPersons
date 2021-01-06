package com.everis.microserviciopersons.models.controllers;

import com.everis.microserviciopersons.models.entity.Person;
import com.everis.microserviciopersons.models.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/core/persons")
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @GetMapping("/all")
    public Flux<Person> encontrarTodo(){
        return iPersonService.findAll();
    }


    @GetMapping("/only")
    public Mono<ResponseEntity<Person>> encontrarPorId(@RequestParam Long id){
        return iPersonService.findById(id).map(p -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Mono<ResponseEntity<Person>> encontrarPorDocumento(@RequestParam String documentNumber) {
        return iPersonService.findByDocument(documentNumber.replaceAll("\"","")).map(p -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
