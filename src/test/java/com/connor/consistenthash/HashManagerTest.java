package com.connor.consistenthash;

import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import static org.junit.jupiter.api.Assertions.*;

class HashManagerTest {

    @Test
    void shouldCreateTheCorrectNumberOfVirtualNodeGivenRangeAndmax_size() {
        HashManager hm = new HashManager(25, 100); //4 buckets of size 25, 1 per vNode
        assertTrue(hm.numVNodes() == 4);
        hm.reCreateVNodes(33, 100); //3 buckets of size 33, remainder discarded
        assertTrue(hm.numVNodes() == 3);
    }

    @Test
    void shouldReturnCorrectRangeForVNode() {
        int range_size = 25, max_size = 100;
        HashManager hm = new HashManager(range_size, max_size); //4 buckets of size 25, 1 per vNode
        for(int i = 0; i < hm.numVNodes(); i++){
            assertTrue(hm.getVnodeRangeStart(i) == (i*range_size));
        }
    }

    @Test
    void shouldReturnCorrectRangeEndForVNodesForCompleteRangePartitions() {
        int range_size = 25, max_size = 200;
        HashManager hm = new HashManager(range_size, max_size); //4 buckets of size 25, 1 per vNode
        for(int i = 0; i < hm.numVNodes(); i++){
            assertTrue(hm.getVNodeRangeEnd(i) == (i*range_size)+range_size);
        }
    }

    @Test
    void shouldReturnCorrectRangeEndForVNodesForIncompletePartitions() {
        int range_size = 33, max_size = 200;
        HashManager hm = new HashManager(range_size, max_size); // 5 buckets of size 33
        for(int i = 0; i < hm.numVNodes(); i++){
            assertTrue(hm.getVNodeRangeEnd(i) == (i*range_size)+range_size);
        }
    }

    @Test
    void shouldReturnConsistentVnodeForAGivenKey() {
        String key = "hello I am going to try to get myself assigned to the same VNode consistently";
        int range_size = 25, max_size = 2000;
        HashManager hm =  new HashManager(range_size, max_size);
        int base_line_hash = hm.getVNode(key);
        for (int i = 0; i < 1000; i++) {
            assertTrue(hm.getVNode(key) == base_line_hash);
            System.out.println(base_line_hash);
        }
    }

    @Test
    void shouldAlwaysReturnAHashWithinTheSpecifiedRange() {
        StringBuilder string_builder =  new StringBuilder("hello I am going to try to get myself assigned to the same VNode consistently");
        int range_size = 25, max_size = 2000, test_size = 1000;;
        HashManager hm =  new HashManager(range_size, max_size);
        for(int i = 0; i< test_size; i++){
            int base_line_hash = hm.getVNode(string_builder.append(i).toString());
            assertTrue( base_line_hash <= hm.numVNodes());
            System.out.println(base_line_hash);
        }
    }

}