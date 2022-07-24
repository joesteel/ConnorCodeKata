package com.connor.codekata1;

import java.util.Arrays;

public class BitMap {
    private static final int WORD_SIZE = 32;

    private int[] bitMap;
    public BitMap(final int size) {
        int number_or_words = (size%WORD_SIZE == 0)? size/WORD_SIZE : size/WORD_SIZE+1;
        bitMap = new int[number_or_words];
    }

    public BitMap(int[] inputArray){
        bitMap = inputArray;
    }

    public int getSize(){
        return bitMap.length;
    }

    public int getBit(final int position){
        int word_index = getWordIndex(position);
        int exact_position = getExactPosition(position);
        int word = bitMap[word_index];
        int bitMask = (1 << exact_position);
        int result = (word & bitMask);
        return result == bitMask ? 1 : 0;
    }

    public void setBit(final int position, final boolean value){
        int word_index = getWordIndex(position);
        int exact_position = getExactPosition(position);
        int word = bitMap[word_index];
        int bitmask = 1;
        if(value){
            // if value is a 1 then shift 1 to the right position and OR it with the existing word
            bitmask <<= exact_position;
            bitMap[word_index] = word | bitmask;
        } else {
            // if value is a 0 then we want a bit mask with all 1s and the 0 at the right position... then And it with the word
            bitmask <<= exact_position;
            bitmask = ~(bitmask);
            bitMap[word_index] = word & bitmask;
        }
    }

    public void printContents(){
        Arrays.stream(bitMap).forEach(x -> {
            System.out.println(Integer.toBinaryString(x));
        });
    }

    public int[] asIntArray(){
        return bitMap;
    }

    private int getWordIndex(final int position){
        return position/WORD_SIZE;
    }

    private int getExactPosition(final int position){
        return position%WORD_SIZE;
    }

}
