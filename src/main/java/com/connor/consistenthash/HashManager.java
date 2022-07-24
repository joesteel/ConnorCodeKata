package com.connor.consistenthash;

import java.math.BigInteger;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashManager {
    private int totalRange;
    private int rangeOfVNode;

    public HashManager(int rangeSize, int maxSize){
        totalRange = maxSize;
        rangeOfVNode = rangeSize;
    }

    public void reCreateVNodes(int rangeSize, int maxSize){
        totalRange = maxSize;
        rangeOfVNode = rangeSize;
    }

    public int numVNodes(){
        return totalRange/rangeOfVNode; // any spill over discarded
    }

   public int getVNode(final String key) throws NoSuchAlgorithmException{
       MessageDigest md = MessageDigest.getInstance("MD5");
       md.update(key.getBytes());
       byte[] hash = md.digest();
       BigInteger big_integer = new BigInteger(hash);
       BigInteger num_buckets = new BigInteger(java.lang.String.valueOf(this.numVNodes()));
       int bucket = big_integer.mod(num_buckets).intValue(); // this will work as numVNodes is of type int
       return bucket;
    }

    public int getVnodeRangeStart(final int vNode) throws IllegalArgumentException {
        if(vNode > numVNodes()-1) {
            throw new IllegalArgumentException();
        }
        return rangeOfVNode * vNode;
    }

    public int getVNodeRangeEnd(final int vNode) throws IllegalArgumentException {
        if(vNode > numVNodes()-1) {
            throw new IllegalArgumentException();
        } else {
            return getVnodeRangeStart(vNode) + rangeOfVNode;
        }
    }

}
