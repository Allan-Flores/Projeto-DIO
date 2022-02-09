package com.dio.personapi.mapper;

import com.dio.personapi.dto.PersonDTO;
import com.dio.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "phones", source = "phones")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
