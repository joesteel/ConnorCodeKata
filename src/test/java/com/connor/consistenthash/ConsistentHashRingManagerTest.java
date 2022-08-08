package com.connor.consistenthash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsistentHashRingManagerTest {

    @Test
    void shouldGetAConsistentServerForAKey() {
        ConsistentHashRingManager chm = new ConsistentHashRingManager(10, 100);
        String key = "I am a little key";
        int serverIdForPut = chm.getServerForKey(key);
        int totalIterations = 100;
        for(int i=0; i<totalIterations;i++){
            assertEquals(chm.getServerForKey(key), serverIdForPut);
        }
    }

    @Test
    void shouldAddAServerToRotation() {
        ConsistentHashRingManager chm = new ConsistentHashRingManager(9, 100);
        String key = "I am a little key";
        int serverIdForPutWith9Servers = chm.getServerForKey(key);
        int newServerId = 9;
        assertEquals(VNodeDistributor.SUCCESS, chm.addServerToRotation(newServerId));
        assertEquals(chm.getServerCount(), 10);
        int numberOfTimesLoadWasDistributedToNewServer = 0;
        StringBuilder builder = new StringBuilder(key);
        int totalIterations = 1000;
        for(int i = 0; i < totalIterations; i++){
            if(chm.getServerForKey(builder.append(i).toString()) == newServerId){
                numberOfTimesLoadWasDistributedToNewServer++;
            }
        }
        assertTrue(numberOfTimesLoadWasDistributedToNewServer > 5);
    }


    @Test
    void shouldRemoveAServerToRotation() {
        ConsistentHashRingManager chm = new ConsistentHashRingManager(10, 100);
        String key = "I am a little key";
        int serverIdForPutWith9Servers = chm.getServerForKey(key);
        int serverToRemove = 9;
        assertEquals(VNodeDistributor.SUCCESS, chm.removeServerFromRotation(serverToRemove));
        assertEquals(chm.getServerCount(), 9);
        int numberOfTimesLoadWasDistributedToServer9 = 0;
        StringBuilder builder = new StringBuilder(key);
        int totalIterations = 1000;
        for(int i = 0; i < totalIterations; i++){
            assertFalse(chm.getServerForKey(builder.append(i).toString()) == serverToRemove);{
            }
        }
    }

}