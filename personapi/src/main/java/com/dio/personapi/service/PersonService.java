package com.dio.personapi.service;

import com.dio.personapi.dto.PersonDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.mapper.PersonMapper;
import com.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public String createPerson(PersonDTO personDTO) {
        Person personParaSalvar = personMapper.toModel(personDTO);

        Person personSalva = personRepository.save(personParaSalvar);
        return "Pessoa salva com id: " + personSalva.getId();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public String delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
        return "Deletada pesssoa com id: " + id;
    }

    public String replace(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personParaSalvar = personMapper.toModel(personDTO);
        Person personSalva = personRepository.save(personParaSalvar);
        return "Pessoa com id " + personSalva.getId() + " atualizada";
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
