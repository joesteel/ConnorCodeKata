package com.connor.leeteasy;

public class OneBitAndTwoBitCharacters {
    public static boolean isOneBitCharacter(int[] bits) {
        int end = bits.length - 1;
        if(isValidOneBitCharacter(bits,end) && !isValidTwoBitCharacter(bits, end-1)) return true;
        boolean valid_sequence_possible = isValidSequencePossible(bits, end-1);
        return !valid_sequence_possible;
    }

    private static boolean isValidSequencePossible(int[] bits, int index){
        if(index == 0) return true;
        if(index < 0) return false;


        boolean sequence_possible_using_one_bit = isValidOneBitCharacter(bits, index-1) && isValidSequencePossible(bits, index-1);
        boolean sequence_possible_using_two_bits = isValidTwoBitCharacter(bits, index-2) && isValidSequencePossible(bits, index-2);
        return sequence_possible_using_one_bit || sequence_possible_using_two_bits;
    }

    private static boolean isValidTwoBitCharacter(int[] bits, int index){
        return (index >= 0 && bits[index] == 1 && (bits[index+1] == 1 || bits[index+1] == 0));
    }

    private static boolean isValidOneBitCharacter(int[] bits, int index){
        return (index >= 0 && bits[index] == 0);
    }

}
