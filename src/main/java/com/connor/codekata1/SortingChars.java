package com.connor.codekata1;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

public class SortingChars {

    private HashMap<Character, Integer> map;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    public SortingChars(){
        map = new HashMap<Character, Integer>();
        CharacterIterator it = new StringCharacterIterator(alphabet);
        while (it.current() != CharacterIterator.DONE)
        {
            map.put(it.current(), 0);
            it.next();
        }
    }

    public String sortChars(String inputString){

        CharacterIterator it = new StringCharacterIterator(inputString.toLowerCase());

        while (it.current() != CharacterIterator.DONE)
        {
            Integer charCount = map.get(it.current());
            if(charCount!=null) {
                charCount += 1;
                map.put(it.current(), charCount);
            }
            it.next();
        }

    return explodeStringFromMap();
    }

    public String explodeStringFromMap(){
        StringBuilder resultString = new StringBuilder();
        CharacterIterator it = new StringCharacterIterator(alphabet);
        while (it.current() != CharacterIterator.DONE)
        {
            for(int i=0; i < map.get(it.current()); i++){
                resultString.append(it.current());
            }
            it.next();
        }
        return resultString.toString();
    }

}
