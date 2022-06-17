package com.purnashis.app.chatment.controller;

import com.purnashis.app.chatment.Repo.FactRepo;
import com.purnashis.app.chatment.Response.ResponseHandler;
import com.purnashis.app.chatment.models.Fact;
import com.purnashis.app.chatment.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ApiControllers {
    @Autowired
    private FactRepo factRepo;

    @Autowired
    private FactService factService;

    @GetMapping(value="/fact")
    public ResponseEntity<Object> giveFact(@RequestParam String animal, HttpServletRequest request) {
        try {
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, factService.getFact(animal, request.getRemoteAddr().toString()));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

        }

    }

    @GetMapping(value="/getfact")
    public ResponseEntity<Object> getFacts() {
        try {
            //return factService.getAllFacts();
            return ResponseHandler.generateResponse("Fetched facts", HttpStatus.OK, factService.getAllFacts());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}


