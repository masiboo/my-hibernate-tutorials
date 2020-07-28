package com.example.onetomany.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();


    //@OneToOne(fetch = FetchType.LAZY, optional = true)
    //  @OneToOne(cascade = CascadeType.ALL)
    //  @JoinColumn(name = "scoreBoard_id", nullable = true)
/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scoreBoard_id", referencedColumnName = "id")
    private ScoreBoard scoreBoard;*/

    /*   public ScoreBoard getScoreBoard() {
           return scoreBoard;
       }

       public void setScoreBoard(ScoreBoard scoreBoard) {
           this.scoreBoard = scoreBoard;
       }
   */
    public Team() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }
        this.players.add(player);
    }
*/

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                //  ", scoreBoard=" + scoreBoard +
                '}';
    }
}
