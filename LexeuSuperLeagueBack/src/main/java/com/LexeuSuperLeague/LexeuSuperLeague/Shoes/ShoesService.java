package com.LexeuSuperLeague.LexeuSuperLeague.Shoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoesService {

    @Autowired
    ShoesRepository shoesRepository;

    /**
     * permet de récupérer toutes les chaussures.
     * @return une liste de chaussures.
     */
    public List<Shoes> findAll() {

        return shoesRepository.findAll();
    }

    /**
     * Permet de récupérer une chaussure par son nom.
     * @param name
     * @return une chaussure.
     */
    public Shoes findShoesByName(String name) {
        return shoesRepository.findBynameContaining(name);
    }

    /**
     * Création d'un modèle de shoes.
     * @param shoes
     * @return la chaussure créée.
     */
    public Shoes create(Shoes shoes) {

        return shoesRepository.save(shoes);
    }

    /**
     * Suppression de la chaussure à partir de son id.
     * @param shoes_id
     */
    public void deleteById(Long shoes_id) {

        shoesRepository.deleteById(shoes_id);
    }

    public Optional<Shoes> getshoesDataById(Long shoes_id) {
        return shoesRepository.findById(shoes_id);
    }

}
