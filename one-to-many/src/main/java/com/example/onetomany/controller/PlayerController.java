package com.example.onetomany.controller;

import com.example.onetomany.model.Player;
import com.example.onetomany.service.PlayerRepository;
import com.example.onetomany.service.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    public static final String POST_REQUEST = "/add/player";
    public static final String GET_ALL_REQUEST = "/all/player";
    public static final String GET_BY_ID_REQUEST = "/player/";
    public static final String PUT_REQUEST = "/update/player";
    public static final String DELETE_REQUEST = "/delete/player/";

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping(path = GET_BY_ID_REQUEST + "{id}")
    public Player getById(@PathVariable(required = true) long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.orElse(null);
    }

    @PostMapping(path = POST_REQUEST)
    public ResponseEntity<?> addOrUpdate(@RequestBody Player player) {
        try {
            playerRepository.save(player);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping(path = GET_ALL_REQUEST)
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @PutMapping(path = PUT_REQUEST)
    public ResponseEntity<?> updateScore(@RequestBody Player player) {
        try {
            playerRepository.save(player);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping(path = DELETE_REQUEST + "{id}")
    public ResponseEntity<?> deleteScoreBoard(@PathVariable(required = true) long id) {
        try {
            playerRepository.deleteById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Score not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Score deleted successfully", HttpStatus.OK);
    }

}
