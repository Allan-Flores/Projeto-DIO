package com.dio.personapi.service;

import com.dio.personapi.dto.PersonDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.mapper.PersonMapper;
import com.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private PersonMapper personMapper = PersonMapper.INSTANCE;

    public String createPerson(PersonDTO personDTO) {
        Person personParaSalvar = personMapper.toModel(personDTO);

        Person personSalva = personRepository.save(personParaSalvar);
        return "Pessoa salva com id: " + personSalva.getId();
    }
}
