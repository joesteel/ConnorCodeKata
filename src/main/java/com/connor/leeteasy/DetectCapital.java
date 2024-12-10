package com.connor.leeteasy;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        boolean allCapitals = true, allLower = true, firstCapitalThenLower = true;
        char[] chars = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            char c = chars[i];
            if(allCapitals && c > 'Z')
                allCapitals = false;
            if(allLower && c < 'a')
                allLower = false;
            if(firstCapitalThenLower && (i == 0 && c > 'Z') || (i >= 1 && c < 'a') )
                firstCapitalThenLower = false;
        }
        return allCapitals || allLower || firstCapitalThenLower;
    }
}
