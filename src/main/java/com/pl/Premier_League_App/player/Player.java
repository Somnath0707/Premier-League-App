package com.pl.Premier_League_App.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_statistic") // CHANGED: Must match your SQL table name exactly
public class Player {

    @Id
    @Column(name = "player_name", unique = true) // SQL column: player_name
    private String name;

    @Column(name = "nation")
    private String nation;

    @Column(name = "position") // SQL column: position
    private String pos;

    @Column(name = "age")
    private Integer age;

    @Column(name = "matches_played") // SQL column: matches_played
    private Integer mp;

    @Column(name = "starts")
    private Integer starts;

    @Column(name = "minutes_played") // SQL column: minutes_played
    private Double min;

    @Column(name = "goals") // SQL column: goals
    private Double gls;

    @Column(name = "assists") // SQL column: assists
    private Double ast;

    @Column(name = "penalties_scored") // SQL column: penalties_scored
    private Double pk;

    @Column(name = "yellow_cards") // SQL column: yellow_cards
    private Double crdy;

    @Column(name = "red_cards") // SQL column: red_cards
    private Double crdr;

    @Column(name = "expected_goals") // SQL column: expected_goals
    private Double xg;

    @Column(name = "expected_assists") // SQL column: expected_assists
    private Double xag;

    @Column(name = "team_name") // SQL column: team_name
    private String team;

    // Constructors
    public Player() {
    }

    public Player(String name, String nation, String pos, Integer age, Integer mp, Integer starts, Double min, Double gls, Double ast, Double pk, Double crdy, Double crdr, Double xg, Double xag, String team) {
        this.name = name;
        this.nation = nation;
        this.pos = pos;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.min = min;
        this.gls = gls;
        this.ast = ast;
        this.pk = pk;
        this.crdy = crdy;
        this.crdr = crdr;
        this.xg = xg;
        this.xag = xag;
        this.team = team;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getGls() {
        return gls;
    }

    public void setGls(Double gls) {
        this.gls = gls;
    }

    public Double getAst() {
        return ast;
    }

    public void setAst(Double ast) {
        this.ast = ast;
    }

    public Double getPk() {
        return pk;
    }

    public void setPk(Double pk) {
        this.pk = pk;
    }

    public Double getCrdy() {
        return crdy;
    }

    public void setCrdy(Double crdy) {
        this.crdy = crdy;
    }

    public Double getCrdr() {
        return crdr;
    }

    public void setCrdr(Double crdr) {
        this.crdr = crdr;
    }

    public Double getXg() {
        return xg;
    }

    public void setXg(Double xg) {
        this.xg = xg;
    }

    public Double getXag() {
        return xag;
    }

    public void setXag(Double xag) {
        this.xag = xag;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}