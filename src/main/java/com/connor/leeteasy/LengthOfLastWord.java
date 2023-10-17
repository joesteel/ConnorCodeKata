package com.connor.leeteasy;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int lengthOfLastWord = 0;
        for(int i = chars.length-1; i >= 0; i-- ){
            if(chars[i] == ' ' && lengthOfLastWord >= 1) break;
            else if ((chars[i] != ' ')) {
                lengthOfLastWord++;
            }
        }
        return lengthOfLastWord;
    }
}
