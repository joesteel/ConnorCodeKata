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
        int status = distributor.firstTimeDistributeVNodesToServers(num_vNodes, serverMap);
        assertEquals(status, VNodeDistributor.SUCCESS);
        for(int i = 1; i<num_servers;i++){
            assertTrue(serverMap.get(i).size() == num_vNodes/num_servers);
        }
    }

    @Test
    void distributionShouldDealWithBadInputs() {
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        assertEquals(distributor.firstTimeDistributeVNodesToServers(10, null),VNodeDistributor.FAILURE);
        HashMap<Integer, ArrayList<Integer>> emptyServerMap = initializeServers(0);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(10, emptyServerMap), VNodeDistributor.FAILURE);
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(100);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(0, serverMap), VNodeDistributor.FAILURE);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(100, serverMap), VNodeDistributor.SUCCESS);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(100, serverMap), VNodeDistributor.FAILURE); //already has vNodes distributed
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
        assertEquals(distributor.reBalanceExistingVNodesAcrossServers(total_vNodes, serverMap), VNodeDistributor.SUCCESS);
        for(int server = 0; server<num_servers;server++){
            assertEquals(serverMap.get(server).size(), 6);
        }
    }

    @Test
    void shouldAddAServerAndDistributeNodesToThatServer() {
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        int num_servers = 20;
        int num_vNodes = 200;
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(num_servers);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(num_vNodes, serverMap), VNodeDistributor.SUCCESS);
        for(int i = 0; i< 5; i++){
            int status = distributor.addServer(num_servers+i, serverMap);
            assertEquals(status, VNodeDistributor.SUCCESS);
        }
        for(int i = 0; i<num_servers; i++){
            assertEquals(serverMap.get(i).size(), 8);
        }
    }


    @Test
    void shouldRemoveAServerAndReDistributeVnodes() {
        VNodeDistributor distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        int num_servers = 20;
        int num_vNodes = 200;
        HashMap<Integer, ArrayList<Integer>> serverMap = initializeServers(num_servers);
        assertEquals(distributor.firstTimeDistributeVNodesToServers(num_vNodes, serverMap), VNodeDistributor.SUCCESS);
        assertEquals(distributor.removeServer(num_servers-1, serverMap), VNodeDistributor.SUCCESS);
        for(int serverId = 0; serverId<num_servers-1; serverId++){
            if(serverId < 10){
                assertEquals(serverMap.get(serverId).size(), 11);
            }
            else  assertEquals(serverMap.get(serverId).size(), 10);
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