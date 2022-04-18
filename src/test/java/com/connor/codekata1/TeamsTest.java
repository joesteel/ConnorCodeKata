package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamsTest {

    @Test
    void shouldCountTheGameFor1Team() {
        Teams league = new Teams();
        int expectedResult = 0;
        int actualResult = league.countLeagueGames(1);
        assert(expectedResult == actualResult);
    }

    @Test
    void shouldCountTheGameFor5Teams() {
        Teams league = new Teams();
        int expectedResult = 10;
        int actualResult = league.countLeagueGames(5);
        assert(expectedResult == actualResult);
    }

    @Test
    void shouldCountTheGameFor10Teams() {
        Teams league = new Teams();
        int expectedResult = 10*9/2;
        int actualResult = league.countLeagueGames(10);
        assert(expectedResult == actualResult);
    }


    @Test
    void shouldCountTheGameForPrimeNumberOfTeams() {
        Teams league = new Teams();
        int expectedResult = 29*28/2;
        int actualResult = league.countLeagueGames(29);
        assert(expectedResult == actualResult);
    }


    @Test
    void shouldCountTheGameFor1TeamUsingSumFunc() {
        Teams league = new Teams();
        int expectedResult = 0;
        int actualResult = league.partitionTeamsAndPlaySum(1);
        assert(expectedResult == actualResult);
    }

    @Test
    void shouldCountTheGameFor5TeamsUsingSumFunc() {
        Teams league = new Teams();
        int expectedResult = 10;
        int actualResult = league.partitionTeamsAndPlaySum(5);
        assert(expectedResult == actualResult);
    }

    @Test
    void shouldCountTheGameFor10TeamsUsingSumFunc() {
        Teams league = new Teams();
        int expectedResult = 10*9/2;
        int actualResult = league.partitionTeamsAndPlaySum(10);
        assert(expectedResult == actualResult);
    }


    @Test
    void shouldCountTheGameForPrimeNumberOfTeamsUsingSumFunc() {
        Teams league = new Teams();
        int expectedResult = 29*28/2;
        int actualResult = league.partitionTeamsAndPlaySum(29);
        assert(expectedResult == actualResult);
    }




}