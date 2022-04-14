package com.connor.codekata1;

public class Teams {

    private int counter;

    public void Teams(){
        counter = 0;
    }

    public int countLeagueGames(int numTeams){

        partitionTeamsAndPlay(numTeams);
        return counter;
    }

    public void partitionTeamsAndPlay(int numTeamsInGroup) {
        if (numTeamsInGroup <= 1) return;

        int rSide = numTeamsInGroup / 2;
        int lSide = numTeamsInGroup - rSide;
        counter += rSide * lSide;

        partitionTeamsAndPlay(rSide);
        partitionTeamsAndPlay(lSide);
    }

}
