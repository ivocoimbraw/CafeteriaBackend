package com.si.apirest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.si.apirest.model.entity.Person;
import com.si.apirest.model.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private final PersonService personService;

    @GetMapping("/get-all")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping
    public String welcome() {
        return "Bienvenido señor presidente";
    }

    @PutMapping("/user/unable/{id}")
    public void unableUser(@PathVariable int id) {
        personService.unableUser(id);
    }

}
