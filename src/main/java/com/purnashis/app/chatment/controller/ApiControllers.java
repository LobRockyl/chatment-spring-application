package com.purnashis.app.chatment.controller;

import com.purnashis.app.chatment.Repo.FactRepo;
import com.purnashis.app.chatment.models.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ApiControllers {
    @Autowired
    private FactRepo factRepo;

    @GetMapping(value="/fact")
    public String giveFact(@RequestParam String animal, HttpServletRequest request){
        //put condition only cat or dog
        String fact = "HelloWorld"+animal;
        String ip = request.getRemoteAddr().toString();
        System.out.println(ip);
        Fact f = new Fact(ip,"sssdg");
        System.out.println(f);
        factRepo.save(f);

        return f.fact;
    }

//    @GetMapping(value="/getfact")
//    public Fact getFact(@RequestParam Long user){
//        return factRepo.findById(user).get();
//        //return "sg";
//    }
    @GetMapping(value="/getfact")
    public List<Fact> getFacts(){
        List<Fact> facts = factRepo.findAll();
        return facts;
    }

}
