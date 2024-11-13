package com.connor.leeteasy;

public class Base7 {
    public static String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean neg = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int x = num % 7;
            sb.append(x);
            num = num / 7;
        }
        if(neg) sb.append("-");
        return sb.reverse().toString();
    }

    public static String convertBase7Recursive(int num){
        if(num < 0) return "-" + convertBase7Recursive(-num);
        if(num < 7) return Integer.toString(num%7);
        return convertBase7Recursive(num/7) + Integer.toString(num % 7);
    }
}
