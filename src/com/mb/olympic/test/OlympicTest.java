package com.mb.olympic.test;

import com.mb.olympic.AthleteEvents;
import com.mb.olympic.Main;
import org.junit.*;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class OlympicTest {

    static int beforeTestCount = 1;
    static int afterTestCount = 1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("before test : " + beforeTestCount++);
    }

    @Test
    public void testAthleteParticipatedThreeOlympics() throws IOException {
        ArrayList<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        int expectedResult = 2984;
        assertEquals(expectedResult , Main.findAthleteParticipatedThreeOlympics(athleteEvents).size());
    }

    @Test
    public void testEventWiseMedalsCount() throws IOException {
        List<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        assertNotNull(Main.findEventWiseMedals(athleteEvents));
    }


    @Test
    public void testHighestFemaleAthleteWonGoldName() throws IOException {
        List<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        Map<String, Integer> expectedResult =  new HashMap<>() ;
        expectedResult.put("Larysa Semenivna Latynina (Diriy-)" ,9);
        assertEquals(expectedResult , Main.findHighestFemaleAthleteWonGold(athleteEvents));
    }

    @Test
    public void testGoldWinnerOfFootball() throws IOException {
        ArrayList<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        int expectedResult = 27;
        assertEquals(expectedResult,Main.findGoldWinnerOfFootball(athleteEvents).size() );
    }

    @Test
    public void testAthletesWonGoldMedal() throws IOException {
        ArrayList<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        assertTrue(Main.findAthletesWonGoldMedal(athleteEvents).size() > 20);
    }

    @Test
    public void testGoldMedalsPerPlayerPerYear() throws IOException {
        ArrayList<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        assertFalse(Main.findGoldMedalsPerPlayerPerYear(athleteEvents).size() < 1);
    }

    @Test
    public void testAthleteEventsDataCount() throws IOException {
        List<AthleteEvents> athleteEvents = Main.getAthleteEventsData();
        int expectedResult = 271116;
        assertEquals(expectedResult, athleteEvents.size());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after test : " + afterTestCount++);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("after class");
    }

}


