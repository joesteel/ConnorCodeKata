package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.HashSet;

public class KeyboardRow {

    public static String[] findWords(String[] words) {
        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();
        ArrayList<HashSet<Character>> hashSets = new ArrayList<>();
        hashSets.add(row1); hashSets.add(row2); hashSets.add(row3);
        ArrayList<String> result = new ArrayList<>();
        for( Character c : "qwertyuiop".toCharArray()) row1.add(c);
        for( Character c : "asdfghjkl".toCharArray()) row2.add(c);
        for( Character c : "zxcvbnm".toCharArray()) row3.add(c);

        for(HashSet<Character> row : hashSets){
            for(String word: words){
                boolean allMatch = true;
                for(char c: word.toLowerCase().toCharArray()){
                    if(!row.contains(c)){
                        allMatch = false;
                        break;
                    }
                }
                if(allMatch) result.add(word);
            }
        }
        String[] resArray = new String[result.size()];
        resArray = result.toArray(resArray);
        return resArray;
    }
}
