package com.example.onetomany.service;

import com.example.onetomany.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PlayerRepository extends JpaRepository<Player, Long>, QueryByExampleExecutor<Player> {

}
