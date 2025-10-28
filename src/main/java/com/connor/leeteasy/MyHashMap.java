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

    private final KeyValuePairNode[] buckets;
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
        KeyValuePairNode key_value_node_ptr = buckets[bucket_index];
        for(; key_value_node_ptr != null; key_value_node_ptr = key_value_node_ptr.next)
            if(key_value_node_ptr.key == key) return key_value_node_ptr.value;
        return -1;
    }

    public void remove(int key) {
        int bucket_index = hash(key);
        KeyValuePairNode key_value_node_ptr = buckets[bucket_index];
        if(key_value_node_ptr == null) return;
        if(key_value_node_ptr.key == key) buckets[bucket_index] = key_value_node_ptr.next;
        else for ( ; key_value_node_ptr.next != null; key_value_node_ptr = key_value_node_ptr.next)
            if(key_value_node_ptr.next.key == key) {
                key_value_node_ptr.next = key_value_node_ptr.next.next;
                return;
            }
    }
}
