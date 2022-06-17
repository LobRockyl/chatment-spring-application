package com.purnashis.app.chatment.service;

import com.purnashis.app.chatment.Repo.FactRepo;
import com.purnashis.app.chatment.Utils.CatResponseFormatter;
import com.purnashis.app.chatment.Utils.DogClass;
import com.purnashis.app.chatment.Utils.Readers.apiConfigReader;
import com.purnashis.app.chatment.models.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FactServiceImpl implements FactService{

    @Autowired
    private apiConfigReader apiConfig;

    @Autowired
    private FactRepo factRepo;

    @Override
    public String getFact(String animal, String ip) {
        if(!Objects.equals(animal, "cat") && !Objects.equals(animal, "dog")){
            throw new IllegalArgumentException("animal should be cat or dog");
        }
        String cat_api_url = apiConfig.getCat_api_url();
        String dog_api_url = apiConfig.getDog_api_url();

        RestTemplate restTemplate = new RestTemplate();

        String fact = "HelloWorld"+animal;
        if(Objects.equals(animal, "cat")){
            CatResponseFormatter factObj = restTemplate.getForObject(cat_api_url, CatResponseFormatter.class);
            fact = factObj.getFact();
        }
        if(Objects.equals(animal, "dog")){

            ResponseEntity<DogClass[]> responseEntity =
                    restTemplate.getForEntity(dog_api_url, DogClass[].class);
            DogClass[] dogArray = responseEntity.getBody();
             fact = Arrays.stream(dogArray)
                    .map(DogClass::getFact)
                    .collect(Collectors.toList()).get(0);
        }
        Fact f = new Fact(ip,fact);
        System.out.println(f);
        factRepo.save(f);

        return f.fact;
    }

    @Override
    public List<Fact> getAllFacts() {
        List<Fact> facts = factRepo.findAll();
        return facts;
    }


}

