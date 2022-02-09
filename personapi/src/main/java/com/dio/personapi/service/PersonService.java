package com.dio.personapi.service;

import com.dio.personapi.entity.Person;
import com.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public String createPerson(Person person) {
        Person personSalva = personRepository.save(person);
        return "Pessoa salva com id: " + personSalva.getId();
    }
}
