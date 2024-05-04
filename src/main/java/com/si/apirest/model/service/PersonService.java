package com.si.apirest.model.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.PersonDTO;
import com.si.apirest.model.entity.Person;
import com.si.apirest.model.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(PersonDTO person, int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person updatedUser = optionalPerson.get();
            modelMapper.map(person, updatedUser);
            personRepository.save(updatedUser);
        }
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Optional<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    public List<PersonDTO> getAllPerson() {
        List<Person> personList = personRepository.findAll(); 
        List<PersonDTO> personDTOs = new ArrayList<>();
        for (Person userPerson : personList) {
            personDTOs.add(modelMapper.map(userPerson, PersonDTO.class));
        }
        return personDTOs;
    }

    public void unableUser(int id) {
        Optional<Person> person= personRepository.findById(id);

        person.ifPresent( user -> {
            user.setEnabled(false);
            personRepository.save(user);
            }
        );
    }

}
