package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BitMapTest {

    @Test
    void shouldSetSizeCorrectly() {
        BitMap myBitMap = new BitMap(1026);
        int size = myBitMap.getSize();
        assert (size == 1024 / 32 + 1); 
    }

    @Test
    void shouldGetBitPosition() {
        BitMap myBitMap = new BitMap(new int[]{0xFFFFFFFF, 0}); //
        // so every position in the first 32 is a 1 and everything in the next 32 is a 0
        myBitMap.printContents();
        for (int i = 0; i <= 31; i++) {
            if (myBitMap.getBit(i) != 1) {
                System.out.println("Failure at " + i);
                assert (false);
            }
        }
        for (int i = 32; i <= 63; i++) {
            if (myBitMap.getBit(i) != 0) {
                System.out.println("Failure at " + i);
                assert (false);
            }
        }
    }


    @Test
    void shouldSetSpecifiedPositionsToOneCorrectly() {
        BitMap myBitMap = new BitMap(new int[]{0, 0});
        // so every position in the first 32 is a 1 and everything position in the next 64 is a 0
        myBitMap.printContents();
        for (int i = 0; i < 64; i++) {
            myBitMap.setBit(i, true);
            myBitMap.printContents();

            if (myBitMap.getBit(i) != 1) {
                System.out.println("Failure at " + i);
                assert (false);
            }
            // make sure it's not messed up the other bits
            for (int j = i + 1; j < 64; j++) {
                if (myBitMap.getBit(j) != 0) {
                    System.out.println("Failure has overwritten subsequent element " + i);
                    assert (false);
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                if (myBitMap.getBit(k) != 1) {
                    System.out.println("Has overwritten previous element " + i);
                    assert (false);
                }
            }
        }

    }

    @Test
    void shouldSetSpecifiedPositionsToZeroCorrectly() {
        BitMap myBitMap = new BitMap(new int[]{0xFFFFFFFF, 0xFFFFFFFF});
        // so every position in the first 32 is a 1 and everything position in the next 64 is a 0
        myBitMap.printContents();
        for (int i = 0; i < 64; i++) {
            myBitMap.setBit(i, false);
            myBitMap.printContents();

            if (myBitMap.getBit(i) != 0) {
                System.out.println("Failure at " + i);
                assert (false);
            }
            // make sure it's not messed up the other bits
            for (int j = i + 1; j < 64; j++) {
                if (myBitMap.getBit(j) != 1) {
                    System.out.println("Failure has overwritten subsequent element " + i);
                    assert (false);
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                if (myBitMap.getBit(k) != 0) {
                    System.out.println("Has overwritten previous element " + i);
                    assert (false);
                }
            }
        }
    }


    @Test
    void shouldSetASingleBitCorrectly(){
        /*
         for a given 32 bit word
         if exact position is 0 then 00000000_00000000_00000001 = 2^0 = 1
         if exact position is 1 then 00000000_00000000_00000010 = 2^1 = 2
         if exact position is 31 then 10000000_00000000_00000000 = -2147483648 != 2^31
         NOTE 2^n does not work when we set bit 32 (index 31) and we sign the integer
         */
        for(int i = 0; i < 100; i++){
            Random myRand = new Random();
            int randomBit = myRand.nextInt(10*32-1);
            BitMap myBitMap = new BitMap(10*32);
            myBitMap.setBit(randomBit, true);
            if(randomBit%32 == 31) {
                if(myBitMap.asIntArray()[randomBit / 32] != -2147483648){
                    System.out.printf("failure at input: %d at word: %d with exact position: %d int value %d\n", i, randomBit / 32, randomBit % 32, myBitMap.asIntArray()[randomBit / 32]);
                    assert (false);
                }
            }
           else {
                if (myBitMap.asIntArray()[randomBit / 32] != (int) Math.pow(2, (randomBit % 32))) {
                    System.out.printf("failure at input: %d at word: %d with exact position: %d int value %d\n", i, randomBit / 32, randomBit % 32, myBitMap.asIntArray()[randomBit / 32]);
                    assert (false);
                }
            }
        }
    }
}