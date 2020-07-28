package com.example.onetomany.controller;

import com.example.onetomany.model.Player;
import com.example.onetomany.model.Team;
import com.example.onetomany.service.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    public static final String POST_REQUEST = "/add/team";
    public static final String GET_ALL_REQUEST = "/all/team";
    public static final String GET_BY_ID_REQUEST = "/team/";
    public static final String PUT_REQUEST = "/update/team";
    public static final String DELETE_REQUEST = "/delete/team/";

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping(path = GET_BY_ID_REQUEST + "{id}")
    public Team getById(@PathVariable(required = true) long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    @PostMapping(POST_REQUEST)
    public ResponseEntity<?> addOrUpdate(@RequestBody Team team) {
        try {
            List<Player> players = team.getPlayers();
            players.forEach( player -> player.setTeam(team));
            teamRepository.save(team);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @GetMapping(path = GET_ALL_REQUEST)
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @PutMapping(path = PUT_REQUEST)
    public ResponseEntity<?> updateScore(@RequestBody Team team) {
        try {
            teamRepository.save(team);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping(path = DELETE_REQUEST + "{id}")
    public ResponseEntity<?> deleteScoreBoard(@PathVariable(required = true) long id) {
        try {
            teamRepository.deleteById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Team deleted successfully", HttpStatus.OK);
    }


}
