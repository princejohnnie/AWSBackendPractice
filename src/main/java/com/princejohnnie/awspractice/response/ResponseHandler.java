package com.princejohnnie.awspractice.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> getResponse(HttpStatus status, Object data) {
        Map<Object, Object> map = new LinkedHashMap<>(); // linkedHashMap to maintain insertion order
        map.put("list", data);

        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> getErrorResponse(HttpStatus status, Object data) {
        Map<Object, Object> map = new LinkedHashMap<>(); // linkedHashMap to maintain insertion order
        map.put("error", data);

        return new ResponseEntity<>(map, status);
    }
}
