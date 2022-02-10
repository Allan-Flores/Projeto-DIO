package com.dio.personapi.service;

import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.dto.request.PhoneDTO;
import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.enums.PhoneType;
import com.dio.personapi.mapper.PersonMapper;
import com.dio.personapi.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void mCreate_fCriaPerson_eMensagem() {//metodo, faz, experado
        //Preparo
        PersonDTO personDTO = criadorPerson.dto();
        Person expectedSavedPerson = criadorPerson.padrao();

        //Execução
        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
        String mensagem = personService.createPerson(personDTO);

        //Teste
        Assertions.assertThat(mensagem).isEqualTo(MessageResponseDTO.createPerson(expectedSavedPerson.getId()));
    }

}

class criadorPerson {

    public static PersonDTO dto() {
        return PersonDTO.builder()
                .id(null)
                .firsName("Allan")
                .lastName("Teixeira")
                .cpf("035.621.510-55")
                .birthDate("24-09-1996")
                .phones(Collections.singletonList(
                        PhoneDTO.builder()
                                .id(null)
                                .type(PhoneType.valueOf("MOBILE"))
                                .number("(51)981782218")
                                .build()))
                .build();
    }

    public static Person padrao() {
        final PersonMapper personMapper = PersonMapper.INSTANCE;
        Person person = personMapper.toModel(dto());
        person.setId(1L);
        person.getPhones().get(0).setId(1L);
        return person;
    }
}