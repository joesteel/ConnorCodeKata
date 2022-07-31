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
        int status = distributor.firstTimeDistributeVNodesToServers(serverMap, num_vNodes);
        assertEquals(status, VNodeDistributor.SUCCESS);
        for(int i = 1; i<num_servers;i++){
            assertTrue(serverMap.get(i).size() == num_vNodes/num_servers);
        }
    }

    @Test
    void distributionShouldDealWithBadInputs() {
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        assertEquals(distributor.firstTimeDistributeVNodesToServers(null, 10),VNodeDistributor.FAILURE);
        HashMap<Integer, ArrayList<Integer>> emptyServerMap = initializeServers(0);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(emptyServerMap, 10), VNodeDistributor.FAILURE);
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(100);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(serverMap, 0), VNodeDistributor.FAILURE);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(serverMap, 100), VNodeDistributor.SUCCESS);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(serverMap, 100), VNodeDistributor.FAILURE); //already has vNodes distributed
    }

    @Test
    void shouldReBalanceASetOfServersWithExistingVNodes(){
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        int num_servers = 4;
        int total_vNodes = 24;
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(num_servers);
        for(int vNode = 0; vNode < 10; vNode++){
            serverMap.get(1).add(vNode);
        }
        for(int vNode = 10; vNode < 14; vNode++){
            serverMap.get(2).add(vNode);
        }
        for(int vNode = 14; vNode < total_vNodes; vNode++){
            serverMap.get(3).add(vNode);
        }
        assertEquals(distributor.reBalanceExistingVNodesAcrossServers(serverMap), VNodeDistributor.SUCCESS);
        int serverId = 0;
        int expected_vNodes_per_server= total_vNodes/num_servers;
        while(serverId<num_servers){
            ArrayList<Integer> list_of_vNodes_for_a_server = serverMap.get(serverId);
            assertEquals(list_of_vNodes_for_a_server.size(), expected_vNodes_per_server);
            for(int vNode_offset=0; vNode_offset<expected_vNodes_per_server; vNode_offset++) {
                assertTrue(list_of_vNodes_for_a_server.contains(serverId*expected_vNodes_per_server + vNode_offset));
            }
            serverId++;
        }
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