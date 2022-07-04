package com.connor.codekata1;

import java.util.Arrays;

public class BitMap {
    private static final int WORD_SIZE = 32;
    private static final int ONES = 0xFFFFFFFF;

    private int[] bitMap;
    public BitMap(int size) {
        int number_or_words = (size%WORD_SIZE == 0)? size/WORD_SIZE : size/WORD_SIZE+1;
        bitMap = new int[number_or_words];
    }

    public BitMap(int[] inputArray){
        bitMap = inputArray;
    }

    public int getSize(){
        return bitMap.length;
    }

    public int getBit(int position){
        int word_index = position/WORD_SIZE;
        int exact_position = position%WORD_SIZE;
        int word = bitMap[word_index];
        int bitMask = (1 << exact_position);
        int result = (word & bitMask);
        return result == bitMask ? 1 : 0;
    }

    public void setBit(int position, boolean value){
        int word_index = position/WORD_SIZE;
        int exact_position = position%WORD_SIZE;
        int word = bitMap[word_index];
        int bitmask = 1;
        if(value == true){
            // if value is a 1 then shift 1 to the right position and OR it with the existing word
            bitmask <<= exact_position;
            bitMap[word_index] = word | bitmask;
        }
        else{
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

}
