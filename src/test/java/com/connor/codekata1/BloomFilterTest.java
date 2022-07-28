package com.connor.codekata1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {


    @Test
    void shouldProduceConsistentHash() {
        int bucket_size = 2048;
        BloomFilter bf = new BloomFilter(bucket_size);
        int sample_size = 10000;
        int iterations = 100;
        for(int i = 0; i<sample_size; i++ ){
            int expected_result = bf.hash(i, bucket_size, 0.5);
            System.out.println("Expected result = " + expected_result);
            for(int j = 0; j< iterations; j++){ // brute force check that it's consistent iterations times
                int actual = bf.hash(i, bucket_size, 0.5);
                assertTrue(actual < bucket_size);
                assertTrue(actual == expected_result);
            }
        }
    }

    @Test
    void shouldAlwaysReturnTrueWhenElementIsInSet() {
        int bucket_size = 2048;
        BloomFilter bf = new BloomFilter(bucket_size);
        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int element = rand.nextInt(2048);
            bf.addElementToSet(element);
            assertTrue (bf.setMayContainElement(element));
        }
    }

    @Test
    void shouldReturnFalseWhenNothingInSet() {
        int bucket_size = 2048;
        BloomFilter bf = new BloomFilter(bucket_size);
        for (int i = 0; i < 100; i++) {
            Random rand = new Random();
            int element = rand.nextInt(2048);
            assertTrue (bf.setMayContainElement(element) == false);
        }
    }
}