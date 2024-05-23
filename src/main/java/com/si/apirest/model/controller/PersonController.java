package com.si.apirest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.si.apirest.model.dto.PersonDTO;
import com.si.apirest.model.dto.PersonDTOupdate;
import com.si.apirest.model.dto.PersonGetDTO;
import com.si.apirest.model.dto.RolGetDTO;
import com.si.apirest.model.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class PersonController {
    @Autowired
    private final PersonService personService;

    @GetMapping("/get-all")
    public List<PersonDTO> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping
    public List<PersonGetDTO> getAllPersonTable() {
        return personService.getAllPersonTable();
    }

    @PutMapping("/update/{id}")
    public void updatePerson(@RequestBody PersonDTOupdate person, @PathVariable int id) {
        personService.updatePerson(person, id);
    }

    @PutMapping("/unable/{id}")
    public void unableUser(@PathVariable int id) {
        personService.unableUser(id);
    }

    @PutMapping("/enable/{id}")
    public void enableUser(@PathVariable int id) {
        personService.enableUser(id);
    }

    @GetMapping("/{username}")
    public PersonDTO getUser(@PathVariable String username) {
        return personService.getUser(username);
    }

    @PutMapping("/rol/{id}")
    public void setRolUser(@RequestBody RolGetDTO rol, @PathVariable int id) {
        personService.setRolUser(id, rol);
    }
}
