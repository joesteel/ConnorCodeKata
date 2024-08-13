package com.connor.leeteasy;

import java.util.Arrays;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        // because the values are constrained a-z a
        // frequency map with a 2d array will work better (will avoid needing to spend nlogn sorting)

        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Arrays.sort(note);
        Arrays.sort(mag);

        int note_ptr = 0, mag_ptr = 0;
        while(note_ptr < note.length && mag_ptr < mag.length){
            if(mag[mag_ptr] > note[note_ptr]) return false;
            if(mag[mag_ptr] < note[note_ptr] ) mag_ptr++;
            else if (mag[mag_ptr] == note[note_ptr]){
                mag_ptr++;
                note_ptr++;;
            }
        }
        return note_ptr == note.length ;
    }
}
