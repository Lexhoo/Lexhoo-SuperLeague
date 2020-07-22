package com.LexeuSuperLeague.LexeuSuperLeague.Shoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping()
public class ShoesController {

    @Autowired
    ShoesService shoesService;

    @Autowired
    ShoesRepository shoesRepository;

    @GetMapping("/shoes")
    public List<Shoes> getAll() {
        return shoesService.findAll();
    }

    @GetMapping("/shoes/{id}")
    public Optional<Shoes> getshoesDataById(@PathVariable("id") long shoes_id) {
        return shoesService.getshoesDataById(shoes_id);
    }

    @PostMapping("/newshoes")
    public Shoes save(@RequestBody Shoes shoes) {
        return shoesService.create(shoes);
    }

    @DeleteMapping("deleteshoes/{id}")
    public void deleteByName(@PathVariable("id") long shoes_id) {
        shoesRepository.deleteById(shoes_id);
    }



}
