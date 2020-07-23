package com.LexeuSuperLeague.LexeuSuperLeague.Team;


import com.LexeuSuperLeague.LexeuSuperLeague.Player.Player;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long team_id;

    @OneToMany (mappedBy = "team")
    @JsonIdentityInfo(
            scope = Team.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
        @JsonIdentityReference(alwaysAsId = true)
    List<Player> playerList;

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String name;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "created")
    private int created;

    @Column(name = "numberoftitle")
    private int numberoftitle;

    @Column(name = "coach")
    private String coach;

    @Column(name = "website")
    private String website;

    @Column(name = "adress")
    private String adress;


    @Lob
    @Column(name = "photo")
    private Blob photo;



    public Team() {
    }

    public Team(Long team_id, String city, String name, String stadium, int created, int numberoftitle, String coach, String website, String adress, Blob photo) {
        this.city = city;
        this.name = name;
        this.stadium = stadium;
        this.created = created;
        this.numberoftitle = numberoftitle;
        this.coach = coach;
        this.website = website;
        this.adress = adress;
        this.photo = photo;
    }


    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getNumberoftitle() {
        return numberoftitle;
    }

    public void setNumberoftitle(int numberoftitle) {
        this.numberoftitle = numberoftitle;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }


}
