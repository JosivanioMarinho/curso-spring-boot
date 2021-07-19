package com.cursoSpringBoot.Curso.Spring.Boot.controller;

import com.cursoSpringBoot.Curso.Spring.Boot.model.Person;
import com.cursoSpringBoot.Curso.Spring.Boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
