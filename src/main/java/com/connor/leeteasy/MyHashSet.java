package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    List<List<Integer>> buckets;
    final int bucketCount = 1000;

    public MyHashSet() {
        buckets = new ArrayList<>(bucketCount);
        for(int i = 0; i< bucketCount; i++) buckets.add(new ArrayList<>());
    }

    public void add(int key) {
        int bucketIndex = key % bucketCount;
        if(buckets.get(bucketIndex) == null) {
            buckets.set(bucketIndex, new ArrayList<>());
        }
        List<Integer> bucket = buckets.get(bucketIndex);
        if(!bucket.contains(key)) bucket.add(key);
    }

    public void remove(int key) {
        int bucketIndex = key % bucketCount;
        if(buckets.get(bucketIndex) == null) return;
        List<Integer> bucket = buckets.get(bucketIndex);
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int bucketIndex = key % bucketCount;
        if(buckets.get(bucketIndex) == null) return false;
        List<Integer> bucket = buckets.get(bucketIndex);
        return bucket.contains(key);
    }
}