package com.LexeuSuperLeague.LexeuSuperLeague.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;


    public List<Player> findAll() {

        return playerRepository.findAll();
    }


    public Player create(Player player) {

        return playerRepository.save(player);
    }


    public void deleteById(Long id) {

        playerRepository.deleteById(id);
    }

    public Optional<Player> getplayerDataById(Long id) {
        return playerRepository.findById(id);
    }

}
