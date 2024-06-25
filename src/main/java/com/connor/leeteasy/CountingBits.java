package com.connor.leeteasy;

public class CountingBits {
    public static int[] countBits(int n) {
        if(n < 0) return new int[]{};

        int[] all_the_bits = new int[n+1];
        if(n == 0) return all_the_bits;

        all_the_bits[1] = 1;
        int p = 0, i = 2;

        while(i <= n){
            int block = (int)Math.pow(2,p);
            // copy last block
            for(int j = 0; j < block && i<= n; j++) {
                all_the_bits[i] = all_the_bits[block + j];
                i++;
            }
            // copy last block again ! This time add 1
            for(int j = 0; j < block && i<= n; j++) {
                all_the_bits[i] = all_the_bits[block + j] + 1;
                i++;
            }
            p++;
        }

        return all_the_bits;
    }
}
