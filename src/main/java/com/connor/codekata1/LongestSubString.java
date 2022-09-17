package com.connor.codekata1;

import java.util.Arrays;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s){
        int longestLength = 0, start = 0, end = 0;
        simpleCharSet set = new simpleCharSet();
        char[] chars = s.toCharArray();
        while(end < chars.length){
            if(set.contains(chars[end])){
                set.remove(chars[start]);
                start++;
            }
            else{
                set.add(chars[end]);
                end++;
            }
            longestLength = (longestLength < end - start) ? end - start : longestLength;
        }
        return longestLength;
    }

    class simpleCharSet {
        final static private int charSetLength = 127;
        // number of chars based on https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

        final private int[] set = new int[charSetLength];

        public simpleCharSet(){
        }

        public void add(int charInt){
            int mappedVal = this.sanatise(charInt);
            set[mappedVal] = 1;
        }

        public void add(char ch){
            int mappedVal = this.sanatise((int)ch);
            set[mappedVal] = 1;
        }

        public void remove(int charInt){
            int mappedVal = this.sanatise(charInt);
            set[mappedVal] = 0;
        }

        public boolean contains(int charInt){
            int mappedVal = this.sanatise(charInt);
            return set[mappedVal]==0 ? false:true;
        }

        public boolean contains(char ch){
            int mappedVal = this.sanatise((int)ch);
            return set[mappedVal]==0? false:true;
        }

        private int sanatise(int charInt) {
            if (charInt >= charSetLength || charInt <= 0 ) {
                return 0;
            }
            return charInt;
        }

        public int countSet(){
            return Arrays.stream(set).filter(x->x==1).sum();
        }
    }
}
