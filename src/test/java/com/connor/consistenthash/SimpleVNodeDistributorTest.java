package com.connor.consistenthash;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SimpleVNodeDistributorTest {

    @Test
    void shouldDistributeVNodesToServersEvenly() {
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        int num_servers = 20;
        int num_vNodes = 200;
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(num_servers);
        int status = distributor.distributeVNodesToServers(serverMap, num_vNodes);
        assertEquals(status, VNodeDistributor.SUCCESS);
        for(int i = 1; i<num_servers;i++){
            assertTrue(serverMap.get(i).size() == num_vNodes/num_servers);
        }
    }

    @Test
    void distributionShouldDealWithBadInputs() {
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        assertEquals(distributor.distributeVNodesToServers(null, 10),VNodeDistributor.FAILURE);
        HashMap<Integer, ArrayList<Integer>> emptyServerMap = initializeServers(0);
        assertEquals(distributor.distributeVNodesToServers(emptyServerMap, 10), VNodeDistributor.FAILURE);
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(100);
        assertEquals(distributor.distributeVNodesToServers(serverMap, 0), VNodeDistributor.FAILURE);
        assertEquals(distributor.distributeVNodesToServers(serverMap, 100), VNodeDistributor.SUCCESS);
        assertEquals(distributor.distributeVNodesToServers(serverMap, 100), VNodeDistributor.FAILURE); //already has vNodes distributed
    }

    private HashMap<Integer, ArrayList<Integer>> initializeServers(int numServers){
        HashMap<Integer, ArrayList<Integer>> serverMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i<numServers; i++){
            ArrayList<Integer> list_of_vNodes_for_a_server = new ArrayList<Integer>();
            serverMap.put(i, list_of_vNodes_for_a_server);
        }
        return serverMap;
    }

}