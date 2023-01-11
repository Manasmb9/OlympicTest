package com.mb.olympic;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {


    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SEX = 2;
    public static final int AGE = 3;
    public static final int HEIGHT = 4;
    public static final int WEIGHT = 5;
    public static final int TEAM = 6;
    public static final int NOC = 7;
    public static final int GAMES = 8;
    public static final int YEAR = 9;
    public static final int SEASON = 10;
    public static final int CITY = 11;
    public static final int SPORT = 12;
    public static final int EVENT = 13;
    public static final int MEDAL = 14;

    public static void main(String[] args) throws IOException {
        ArrayList<AthleteEvents> athleteEvents = getAthleteEventsData();
       findGoldMedalsPerPlayerPerYear(athleteEvents);
        findAthletesWonGoldMedal(athleteEvents);
        findGoldWinnerOfFootball(athleteEvents);
        findHighestFemaleAthleteWonGold(athleteEvents);
        findEventWiseMedals(athleteEvents);
        findAthleteParticipatedThreeOlympics(athleteEvents);
        findFemaleAthletes(athleteEvents);
    }

    private static void findFemaleAthletes(ArrayList<AthleteEvents> athleteEvents) {
        List<String> femaleName = new LinkedList<>();
        for(AthleteEvents athleteEvent : athleteEvents){

            if(athleteEvent.getSex() == 'F' && athleteEvent.getTeam().equals("China") && athleteEvent.getAge() < 25 ){
                String name = athleteEvent.getName();
                femaleName.add(name);
            }
        }
        System.out.println(femaleName);
    }

    public static List<String> findAthleteParticipatedThreeOlympics(ArrayList<AthleteEvents> athleteEvents) {
        Set<Integer> years = new HashSet<>();
        HashMap<String, List<Integer>> player = new HashMap<>();
        for (AthleteEvents athleteEvent : athleteEvents) {
            years.add(athleteEvent.getYear());
        }
        for (Integer year : years){
            for (AthleteEvents athleteEvent : athleteEvents) {
                if(athleteEvent.getYear() == year) {
                    if (player.containsKey(athleteEvent.getName())) {
                        if (!player.get(athleteEvent.getName()).contains(year)) {
                            player.get(athleteEvent.getName()).add(year);
                        }
                    } else {
                        player.put(athleteEvent.getName(), new LinkedList<>());
                        player.get(athleteEvent.getName()).add(year);
                    }
                }
            }
        }
        Set<String> names = player.keySet();
        List<String> players = new LinkedList<>();
        for(String name:names){
            if(player.containsKey(name) && player.get(name).size()>3){
                players.add(name);
            }
        }
            return players;
    }


    public static  HashMap<String, HashMap<String, Integer>> findEventWiseMedals(List<AthleteEvents> athleteEvents) {
        HashMap<String, HashMap<String, Integer>> eventWiseMedals = new HashMap<>();
        for (AthleteEvents athleteEvent : athleteEvents) {
            if (athleteEvent.getYear() == 1980) {
                if (eventWiseMedals.containsKey(athleteEvent.getEvent())) {
                    HashMap<String, Integer> playerMap = eventWiseMedals.get(athleteEvent.getEvent());
                    if(athleteEvent.getMedal().equals("Gold")){
                        if (playerMap.containsKey("G")) {
                            eventWiseMedals.get(athleteEvent.getEvent()).put("G",  playerMap.get("G") + 1);
                        }
                        else{
                            playerMap.put("G",1);
                        }
                    }
                    if(athleteEvent.getMedal().equals("Silver")){
                        if (playerMap.containsKey("S")) {
                            eventWiseMedals.get(athleteEvent.getEvent()).put("S", playerMap.get("S") + 1);
                        }
                        else{
                            playerMap.put("S",1);
                        }
                    }
                    if(athleteEvent.getMedal().equals("Bronze")){
                        if (playerMap.containsKey("B")) {
                            eventWiseMedals.get(athleteEvent.getEvent()).put("B", playerMap.get("B") + 1);
                        }
                        else{
                            playerMap.put("B",1);
                        }
                    }
                }
                else {
                    eventWiseMedals.put(athleteEvent.getEvent(), new HashMap<String, Integer>());
                    if (athleteEvent.getMedal().equals("Gold")) {
                        eventWiseMedals.get(athleteEvent.getEvent()).put("G", 1);
                    }
                    else if (athleteEvent.getMedal().equals("Silver")) {
                        eventWiseMedals.get(athleteEvent.getEvent()).put("S", 1);
                    }
                    else if (athleteEvent.getMedal().equals("Bronze")) {
                        eventWiseMedals.get(athleteEvent.getEvent()).put("B", 1);
                    }
                }
            }
        }
        return eventWiseMedals;
    }

    public static Map<String, Integer> findHighestFemaleAthleteWonGold(List<AthleteEvents> athleteEvents) {
        HashMap<String , Integer> femaleAthleteGold = new HashMap<>();
        for(AthleteEvents athleteEvent : athleteEvents){
            if(athleteEvent.getSex() == 'F' && athleteEvent.getMedal().equals("Gold")){
                if(femaleAthleteGold.containsKey(athleteEvent.getName())){
                    femaleAthleteGold.put(athleteEvent.getName(), femaleAthleteGold.get(athleteEvent.getName())+1);
                }
                else{
                    femaleAthleteGold.put(athleteEvent.getName(), 1);
                }
            }

        }
        int goldMedalCount = 0;
        Map<String, Integer> femaleAthleteWonGold = new HashMap<>();
        for(Map.Entry<String , Integer> femaleWonGold : femaleAthleteGold.entrySet()){
            String name = femaleWonGold.getKey();
            int goldCount = femaleWonGold.getValue();
            if(goldCount > goldMedalCount){
                femaleAthleteWonGold.clear();
                femaleAthleteWonGold.put(name , goldCount);
                goldMedalCount = goldCount;
            }
            else if(goldMedalCount == goldCount){
                femaleAthleteWonGold.put(name, goldCount);
            }
        }
        return femaleAthleteWonGold;
    }

    public static Map<Integer, Set<String>> findGoldWinnerOfFootball(ArrayList<AthleteEvents> athleteEvents) {
        Map<Integer, Set<String>> goldWinnerOfFootball = new HashMap<>();
        for(AthleteEvents athleteEvent: athleteEvents){
            if(athleteEvent.getSport().equals("Football")){
                int year = athleteEvent.getYear();
                String name = athleteEvent.getName();
                if(goldWinnerOfFootball.containsKey(year)){
                    Set<String> athleteName = goldWinnerOfFootball.get(year);
                    athleteName.add(name);
                }else{
                    Set<String> athleteName = new HashSet<>();
                    athleteName.add(name);
                    goldWinnerOfFootball.put(year, athleteName);
                }
            }
        }
        return goldWinnerOfFootball;
    }

    public static List<String> findAthletesWonGoldMedal(ArrayList<AthleteEvents> athleteEvents) {
        List<String> athlete = new LinkedList<>();
        for (AthleteEvents athleteEvent : athleteEvents) {
                if (athleteEvent.getYear() == 1980 && (athleteEvent.getAge() > 0 && athleteEvent.getAge() < 30) && athleteEvent.getMedal().equals("Gold")) {
                    String name = athleteEvent.getName();
                    athlete.add(name);
                }
        }
        return athlete;
    }

    public static Map<Integer, Map<String, Integer>> findGoldMedalsPerPlayerPerYear(ArrayList<AthleteEvents> athleteEvents) {
        Map<Integer, Map<String, Integer>> goldPlayerPerYear = new HashMap<>();
        for(AthleteEvents athleteEvent : athleteEvents){
            if(athleteEvent.getMedal().equals("Gold")){
                if(goldPlayerPerYear.containsKey(athleteEvent.getYear())){
                    Map<String, Integer> goldMedalWon = goldPlayerPerYear.get(athleteEvent.getYear());
                    if (goldMedalWon.containsKey(athleteEvent.getName())){
                       goldMedalWon.put(athleteEvent.getName(), goldMedalWon.get(athleteEvent.getName())+1);
                    }
                    else {
                        goldMedalWon.put(athleteEvent.getName(), 1);
                    }
                }
                else {
                    Map<String, Integer> goldMedalWon = new HashMap<>();
                    goldMedalWon.put(athleteEvent.getName(), 1);
                    goldPlayerPerYear.put(athleteEvent.getYear() , goldMedalWon);
                }
            }
        }
        return goldPlayerPerYear;

    }

    public static ArrayList<AthleteEvents> getAthleteEventsData() throws IOException {
        String filePath = "/home/dell/Downloads/athlete_events.csv";
        CSVReader Reader = new CSVReader(new FileReader(filePath));
        String[] csvHeader = Reader.readNext();
        String[] data = Reader.readNext();
        ArrayList<AthleteEvents> athleteEvents = new ArrayList<>();

        while (data != null) {

            if (data[3].equals("NA")) {
                data[3] = "-1";
            }

            if (data[4].equals("NA")) {
                data[4] = "-1";
            }

            if (data[5].equals("NA")) {
                data[5] = "-1";
            }
            AthleteEvents athleteEvent = new AthleteEvents();
            athleteEvent.setId(Integer.parseInt(data[ID]));
            athleteEvent.setName(data[NAME]);
            athleteEvent.setSex(data[SEX].charAt(0));
            athleteEvent.setAge(Integer.parseInt(data[AGE]));
            athleteEvent.setHeight(Integer.parseInt((data[HEIGHT])));
            athleteEvent.setWeight(Float.parseFloat(data[WEIGHT]));
            athleteEvent.setTeam(data[TEAM]);
            athleteEvent.setNoc(data[NOC]);
            athleteEvent.setGames(data[GAMES]);
            athleteEvent.setYear(Integer.parseInt((data[YEAR])));
            athleteEvent.setSeason(data[SEASON]);
            athleteEvent.setCity(data[CITY]);
            athleteEvent.setSport(data[SPORT]);
            athleteEvent.setEvent(data[EVENT]);
            athleteEvent.setMedal(data[MEDAL]);
            athleteEvents.add(athleteEvent);
            data = Reader.readNext();
        }
            return athleteEvents;
        }
    }

