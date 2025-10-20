package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    // so I think we need to modulo the key to get a bucket, that's nice and simple way to do it
    // then we need to store the keys in a list at that bucket

    // An array will work for the list of possible buckets
    // then we can use a linked list or array list for the keys at that bucket
    // if we use a linked list it would either have to be ordered or we would have to search the whole list
    // if we use an array list we can just use the contains method to check if the key is present
    // the only issue is resizing the arraylist if it gets too big but that's an o(n) operation anyway so it should be fine
    // we can also use a boolean array to represent the presence of keys within a range... though for this simple implementation not sure it'll be neccessary
    // we could get clever and do an insert sort to keep the list ordered and then do a binary search to check for presence... but that seems like overkill

    // interesting questions... how many buckets should we have? inputs are 10^4 so maybe 1000 buckets?
    // we should also lazy initialize the buckets to save space

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