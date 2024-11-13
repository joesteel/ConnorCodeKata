package com.connor.leeteasy;

import java.util.*;


public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        int[] sortedScores = Arrays.copyOf(score, score.length);
        Arrays.sort(sortedScores);
        Map<Integer, String> scorePositions = new HashMap<>();
        // sort the scores so we know absolute position

        for(int i = 0; i < sortedScores.length; i++){
            // for each score keep a map of it's position
            String pos = Integer.toString(sortedScores.length-i);
            scorePositions.put(sortedScores[i], pos);
        }
        for(int i = 0; i < score.length; i++){
            String pos  = scorePositions.get(score[i]);
            if (Objects.equals(pos, "1")) pos = "Gold Medal";
            else if(Objects.equals(pos, "2")) pos = "Silver Medal";
            else if(Objects.equals(pos, "3")) pos = "Bronze Medal";
            result[i] = pos;

        }
        return result;
    }
}
