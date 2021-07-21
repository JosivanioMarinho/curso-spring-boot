package com.cursoSpringBoot.Curso.Spring.Boot.service;

import com.cursoSpringBoot.Curso.Spring.Boot.converter.DozerConverter;
import com.cursoSpringBoot.Curso.Spring.Boot.exception.ResourceNotFoundException;
import com.cursoSpringBoot.Curso.Spring.Boot.model.Person;
import com.cursoSpringBoot.Curso.Spring.Boot.modelVO.PersonVO;
import com.cursoSpringBoot.Curso.Spring.Boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonVO create(PersonVO person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseListObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        var entity = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        Person entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id"));
        personRepository.delete(entity);
    }
}
