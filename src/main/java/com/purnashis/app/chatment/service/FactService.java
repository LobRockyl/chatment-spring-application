package com.purnashis.app.chatment.service;

import com.purnashis.app.chatment.models.Fact;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FactService {
    String getFact(String animal, String ip);
    List<Fact> getAllFacts();
}
