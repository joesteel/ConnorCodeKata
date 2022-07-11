package com.connor.codekata1;

import java.util.Arrays;

public class BloomFilter {

    private BitMap bitMap;
    private double[] modifiers;
    private int bits;
    public BloomFilter(int size){
        bits = size;
        bitMap = new BitMap(bits);
        modifiers = new double[]{0.5, 0.2, 0.3333}; // magic modifiers for use in the 3 hash functions
    }

    public void addElementToSet(int element){
        Arrays.stream(modifiers).forEach(x -> {
            int hash = hash(element, bits, x);
            bitMap.setBit(hash, true);
        });
    }

    boolean setMayContainElement(int element) {
        int matches = Arrays.stream(modifiers).mapToInt(x-> bitMap.getBit(hash(element, bits, x))).sum();
        return matches == modifiers.length;
    }

    /*
    todo - ideally configurable Hashing strategy where hashTypes are passed in when creating the BloomFilter
     Potentially we could do a hash interface where each hashType implements a particular type of hash algo
     then BloomFilter can use a HashFactory to specify which types of hash algo it wants to use in the contructor
     but whatever... this is fine for now
     */

    public int hash(int key, int bucketSize, double modifier ){
        /*
        A = 0.5*(sqrt(5) - 1)
        s = floor(A * 2^w)
        x = k*s
        h(k) = x >> (w-p)
        */
        int p = (int)(Math.log(bucketSize) / Math.log(2)); // get the bits required to make a bucket that big
        int w = 32;
        double a = modifier*(Math.sqrt(5)-1); // number between 0-1
        int s = (int)Math.floor(a*Math.pow(2,w-2)); // expand it out to a number between 0-2^30 (large integer space)
        int x = s*key; // scale out x by s
        int hash = x >> w-p; // strip off the most significant p bits (which will basically mod it to the bucket size)
        return Math.abs(hash);
    }
}
