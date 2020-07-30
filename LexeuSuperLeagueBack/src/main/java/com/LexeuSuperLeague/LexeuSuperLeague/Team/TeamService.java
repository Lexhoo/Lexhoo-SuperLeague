package com.LexeuSuperLeague.LexeuSuperLeague.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired TeamRepository teamRepository;

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team create(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById (Long id) {
        teamRepository.deleteById(id);
    }
}
