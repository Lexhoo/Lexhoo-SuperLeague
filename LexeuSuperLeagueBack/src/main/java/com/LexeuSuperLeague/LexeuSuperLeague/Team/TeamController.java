package com.LexeuSuperLeague.LexeuSuperLeague.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Team> getteamDataById(@PathVariable("id") long team_id) {
        Optional<Team> teamData = teamRepository.findById(team_id);

        if (teamData.isPresent()) {
            return new ResponseEntity<>(teamData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Team save(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping("update/{id}")
    public Team updateTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Team team,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            team.setId(id);
            return "update-user";
        }

        teamRepository.save(team);
        model.addAttribute("teams", teamRepository.findAll());
        return "index";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        teamRepository.delete(team);
        model.addAttribute("teams", teamRepository.findAll());
        return "index";
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


}

