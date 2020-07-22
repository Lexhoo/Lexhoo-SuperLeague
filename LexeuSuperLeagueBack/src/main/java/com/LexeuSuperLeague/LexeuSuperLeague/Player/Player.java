package com.LexeuSuperLeague.LexeuSuperLeague.Player;

import com.LexeuSuperLeague.LexeuSuperLeague.Shoes.Shoes;
import com.LexeuSuperLeague.LexeuSuperLeague.Team.Team;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private int age;
    private String nationality;
    private int height;
    private int weight;
    private String post;
    private int salary;
    private int statpoint;
    private int draftyear;

    @Lob
    private Blob photo;

    private String videolink;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public Player() {
    }

    /**
     * Un joueur peut avoir plusieurs modèles de chaussures.
     */

    @ManyToMany
    @JoinTable(name = "player_shoes",
    joinColumns = @JoinColumn(name = "player_id"),
    inverseJoinColumns = @JoinColumn(name = "shoes_id"))
    private List<Shoes> shoesList = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStatpoint() {
        return statpoint;
    }

    public void setStatpoint(int statpoint) {
        this.statpoint = statpoint;
    }

    public int getDraftyear() {
        return draftyear;
    }

    public void setDraftyear(int draftyear) {
        this.draftyear = draftyear;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
