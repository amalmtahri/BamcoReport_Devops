package com.application.bamcoreport.DTO.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JsonResponse <T> {
    private String message;
    private T object;

    public JsonResponse(String message) {
        this.message = message;
    }
}
