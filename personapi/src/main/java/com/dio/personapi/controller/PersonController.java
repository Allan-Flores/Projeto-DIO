package com.dio.personapi.controller;

import com.dio.personapi.dto.PersonDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
        //return "veio: " + personDTO;
    }


//    @PostMapping(path = "/fone")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String createPhone(@RequestBody List<PhoneDTO> phoneDTO) {
//        List<PhoneDTO> phoneDTO1 = phoneDTO;
//        return "Fone salvo";
//    }
 }
