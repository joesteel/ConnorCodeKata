package com.connor.leeteasy;

public class ValidWord {

    public static boolean isValid(String word) {
        if(word.length() < 3) return false;
        final boolean failDueToSpecialChar = false;
        boolean containsVowel = false;
        boolean containsConsonant = false;

        for(char c: word.toLowerCase().toCharArray()){
            if( ((int)c  < 97 || (int)c > 122) && ((int)c  < 48 || (int)c > 57))  return failDueToSpecialChar; // no special chars
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                containsVowel = true;
                continue;
            }
            if((int)c > 57) containsConsonant = true;
        }
        return containsVowel && containsConsonant;
    }
}
