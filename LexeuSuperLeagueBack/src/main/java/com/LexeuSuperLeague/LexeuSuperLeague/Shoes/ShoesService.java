package com.LexeuSuperLeague.LexeuSuperLeague.Shoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoesService {

    @Autowired
    ShoesRepository shoesRepository;


    public List<Shoes> findAll() {

        return shoesRepository.findAll();
    }


    public Shoes findShoesByName(String name) {
        return shoesRepository.findBynameContaining(name);
    }


    public Shoes create(Shoes shoes) {

        return shoesRepository.save(shoes);
    }


    public void deleteById(Long shoes_id) {

        shoesRepository.deleteById(shoes_id);
    }

    public Optional<Shoes> getshoesDataById(Long shoes_id) {
        return shoesRepository.findById(shoes_id);
    }

}
