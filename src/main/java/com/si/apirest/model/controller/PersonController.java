package com.si.apirest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.si.apirest.model.dto.PersonDTO;
import com.si.apirest.model.entity.Person;
import com.si.apirest.model.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PersonController {
    @Autowired
    private final PersonService personService;

    @GetMapping("/get-all")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @PutMapping("/update/{id}")
    public void testing(PersonDTO person, int id) {
        personService.updatePerson(person, id);
    }

    @PutMapping("/unable/{id}")
    public void unableUser(@PathVariable int id) {
        personService.unableUser(id);
    }

}
