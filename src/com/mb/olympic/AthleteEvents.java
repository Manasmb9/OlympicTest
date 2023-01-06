package com.mb.olympic;

public class AthleteEvents {

    private int id;

    private String name;

    private char sex;

    private int age;

    private int height;

    private float weight;

    private String team;

    private String noc;

    private String games;

    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNoc() {
        return noc;
    }

    public void setNoc(String noc) {
        this.noc = noc;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    private String season;

    private String city;

    private String sport;

    @Override
    public String toString() {
        return "AthleteEvents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", team='" + team + '\'' +
                ", noc='" + noc + '\'' +
                ", games='" + games + '\'' +
                ", year=" + year +
                ", season='" + season + '\'' +
                ", city='" + city + '\'' +
                ", sport='" + sport + '\'' +
                ", event='" + event + '\'' +
                ", medal='" + medal + '\'' +
                '}';
    }

    private String event;

    private String medal;


}
