package com.LexeuSuperLeague.LexeuSuperLeague.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping()
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/teams")
    public List<Team> getAll() {
        return teamService.findAll();
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTutorialById(@PathVariable("id") long id) {
        Optional<Team> tutorialData = teamRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Team save(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Team> updateTutorial(@PathVariable("id") long id, @RequestBody Team team) {
        Optional<Team> tutorialData = teamRepository.findById(id);

        if (tutorialData.isPresent()) {
            Team _team = tutorialData.get();
            _team.setName(team.getName());
            _team.setAdress(team.getAdress());
            _team.setCity(team.getCity());
            _team.setCoach(team.getCoach());
            _team.setCreated(team.getCreated());
            _team.setNumberoftitle(team.getNumberoftitle());
            _team.setPhoto(team.getPhoto());
            _team.setStadium(team.getStadium());
            _team.setWebsite(team.getWebsite());
            return new ResponseEntity<>(teamRepository.save(_team), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleteByName(@PathVariable Long id) {
        teamService.deleteById(id);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            teamRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<Team>> findByPublished() {
//        try {
//            List<Team> tutorials = teamRepository.findByPublished(true);
//
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//    }
}

