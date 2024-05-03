package com.si.apirest.model.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Person;
import com.si.apirest.model.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.save((person));
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void unableUser(int id) {
        Optional<Person> person= personRepository.findById(id);

        person.ifPresent( user -> {
            user.setEnabled(false);
            System.out.println("Supuestamente está deshabilitado: \n" + user.toString());
            personRepository.save(user);
            }
        );
    }

}
