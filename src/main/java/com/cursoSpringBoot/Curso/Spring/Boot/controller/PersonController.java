package com.cursoSpringBoot.Curso.Spring.Boot.controller;

import com.cursoSpringBoot.Curso.Spring.Boot.modelVO.PersonVO;
import com.cursoSpringBoot.Curso.Spring.Boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public PersonVO create(@RequestBody PersonVO person){
        return service.create(person);
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<PersonVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public PersonVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PutMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public PersonVO update(@RequestBody PersonVO person){
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
