package com.dio.personapi.dto.response;

import lombok.Builder;
import lombok.Data;


public class MessageResponseDTO {

    public static String createPerson(Long id){
        return "Pessoa salva com id: " + id;
    }

    public static String delete(Long id) {
        return "Deletada pesssoa com id: " + id;
    }

    public static String replace(Long id) {
        return "Pessoa com id " + id + " atualizada";
    }
}
