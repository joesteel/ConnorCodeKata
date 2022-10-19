package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class SimpleVNodeDistributor implements VNodeDistributor{

    SimpleVNodeDistributor() {
    }

    public int addServer(final int serverId, HashMap<Integer, ArrayList<Integer>> serverMap){
        if(serverId != serverMap.size()) {
            System.out.println("Can only support adding new server with ServerId: " + serverMap.size());
            return FAILURE;
        }
        ArrayList<Integer> list_of_vNodes_for_new_Server = new ArrayList<Integer>();
        serverMap.put(serverMap.size(),list_of_vNodes_for_new_Server);
        return reBalanceExistingVNodesAcrossServers(countExistingVNodes(serverMap), serverMap);
     }

    public int removeServer(final int serverId, HashMap<Integer, ArrayList<Integer>> serverMap) {
        if (serverId != serverMap.size()-1) {
            System.out.println("Can only support removing the last server from rotation, ServerId: " + (serverMap.size()-1));
            return FAILURE;
        }
        int totalVNodes = countExistingVNodes(serverMap);
        serverMap.remove(serverMap.size()-1);
        return reBalanceExistingVNodesAcrossServers(totalVNodes, serverMap);
    }


    public int firstTimeDistributeVNodesToServers(final int totalVNodes, HashMap<Integer, ArrayList<Integer>> serverMap){
        if(serverMap == null) return FAILURE;
        int servers = serverMap.size();
        for(int serverId=0; serverId<servers; serverId++){
            if(!serverMap.get(serverId).isEmpty()){
                System.out.printf("Server %d already has VNodes, aborting operation", serverId);
                return FAILURE;
            }
        }
        return roundRobinVNodesToServers(totalVNodes, serverMap);
    }
    public int reBalanceExistingVNodesAcrossServers(final int totalVNodes, HashMap<Integer, ArrayList<Integer>> serverMap){
        for(int serverId = 0; serverId<serverMap.size();serverId++) {
            serverMap.get(serverId).clear();
        }
        return roundRobinVNodesToServers(totalVNodes, serverMap);
    }

    private int countExistingVNodes(HashMap<Integer, ArrayList<Integer>> serverMap){
        int totalVNodes = 0;
        for(int serverId = 0; serverId<serverMap.size();serverId++) {
            totalVNodes += serverMap.get(serverId).size();
        }
        return totalVNodes;
    }

    private int roundRobinVNodesToServers(final int numVNodes, HashMap<Integer, ArrayList<Integer>> serverMap){
        if(numVNodes <= 0) return FAILURE;
        if(serverMap == null) return FAILURE;
        int activeServers = serverMap.size();
        if(activeServers <= 0) return FAILURE;
        int vNode_capacity_per_Server = numVNodes/activeServers;
        if(vNode_capacity_per_Server <= 0) return FAILURE;
        for(int vNode=0; vNode<numVNodes; vNode++){
            int targetServer = vNode%activeServers;
            serverMap.get(targetServer).add(vNode);
        }
        return SUCCESS;
    }
}