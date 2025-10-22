package com.connor.leeteasy;

public class MyHashMap {

    private static class KeyValuePairNode {
        int key;
        int value;
        KeyValuePairNode next;

        KeyValuePairNode(int key, int value, KeyValuePairNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    final private KeyValuePairNode[] buckets;
    private final static int bucketCount = 1000;
    private final static int prime = 1259;

    public MyHashMap() {
        buckets = new KeyValuePairNode[bucketCount];
    }

    private int hash(int key) {
        long seed = (long )key * prime;
        return (int) (seed % bucketCount);
    }

    public void put(int key, int value) {
        remove(key);
        int bucket_index = hash(key);
        KeyValuePairNode bucket = buckets[bucket_index];
        KeyValuePairNode newNode = new KeyValuePairNode(key, value, bucket);
        buckets[bucket_index] = newNode;
    }

    public int get(int key) {
        int bucket_index = hash(key);
        KeyValuePairNode ptr = buckets[bucket_index];
        for(; ptr != null; ptr = ptr.next)
            if(ptr.key == key) return ptr.value;
        return -1;
    }

    public void remove(int key) {
        int bucket_index = hash(key);
        KeyValuePairNode ptr = buckets[bucket_index];
        if(ptr == null) return;
        if(ptr.key == key) buckets[bucket_index] = ptr.next;
        else for ( ; ptr.next != null; ptr = ptr.next)
            if(ptr.next.key == key) {
                ptr.next = ptr.next.next;
                return;
            }
    }
}
