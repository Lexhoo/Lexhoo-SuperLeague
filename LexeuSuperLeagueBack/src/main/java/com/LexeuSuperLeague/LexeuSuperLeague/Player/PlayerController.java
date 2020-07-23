package com.LexeuSuperLeague.LexeuSuperLeague.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping()
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/player")
    public List<Player> getAll() {
        return playerService.findAll();
    }

    @GetMapping("/player/{id}")
    public Optional<Player> getplayerDataById(@PathVariable("id") long player_id) {
        return playerService.getplayerDataById(player_id);
    }

    @PostMapping("/newplayer")
    public Player save(@RequestBody Player player) {
        return playerService.create(player);
    }

    @DeleteMapping("deleteplayer/{id}")
    public void deleteByName(@PathVariable("id") long player_id) {
        playerRepository.deleteById(player_id);
    }

}
