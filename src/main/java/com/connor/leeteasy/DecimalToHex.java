package com.connor.leeteasy;

public class DecimalToHex {

    public static String toHex(int num) {
        if (num == 0) return "0";
        char[] hexLookUp = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder(8);
        int mask = 0xf;

        while(num != 0){
            int workingBits = num & mask;
            sb.insert(0, hexLookUp[workingBits]);
            num >>>= 4;
        }

        return sb.toString();
    }
}
