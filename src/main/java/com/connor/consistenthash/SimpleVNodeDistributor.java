package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class SimpleVNodeDistributor implements VNodeDistributor{

    SimpleVNodeDistributor() {
        // could keep map of active serversId at some point (arraylist of ids or just an boolean[] of max 1000 with active servers set to 1
        // but for now just assuming something else is managing serverIds and we only have server id 0 up to total size of ServerMap
    }

    /*
    todo
     add a few more tests for add server and removeServer
     then make a distributor implementation that keeps a list of active server Ids
      - right now this one just assumes if the serverMap is of size n we have serverId:0, serverId:1, serverId:2... serverId:n-1 active servers
     once we have a list of servers in rotation then we can add and remove specific serverIds
     as well as rebalance taking into account which ones are active
     */

    public int addServer(int serverId, HashMap<Integer, ArrayList<Integer>> serverMap){
        if(serverId != serverMap.size()) {
            System.out.println("Can only add a ServerId: " + serverMap.size());
            return FAILURE;
        }
        ArrayList<Integer> list_of_vNodes_for_new_Server = new ArrayList<Integer>();
        serverMap.put(serverMap.size(),list_of_vNodes_for_new_Server );
        return reBalanceExistingVNodesAcrossServers(serverMap);
     }

    public int removeServer(int serverId, HashMap<Integer, ArrayList<Integer>> serverMap) {
        if (serverId != serverMap.size()-1) {
            System.out.println("Can only the last server from rotation, ServerId: " + (serverMap.size()-1));
            return FAILURE;
        }
        serverMap.remove(serverMap.size()-1);
        return reBalanceExistingVNodesAcrossServers(serverMap);
    }


    public int firstTimeDistributeVNodesToServers(HashMap<Integer, ArrayList<Integer>> serverMap, int VNodes){
        if(serverMap == null) return FAILURE;
        int servers = serverMap.size();
        for(int serverId=0; serverId<servers; serverId++){
            if(!serverMap.get(serverId).isEmpty()){
                System.out.printf("Server %d already has VNodes, aborting operation", serverId);
                return FAILURE;
            }
        }
        return roundRobinVNodesToServers(VNodes, serverMap);
    }

    public int reBalanceExistingVNodesAcrossServers(HashMap<Integer, ArrayList<Integer>> serverMap){
        int totalVNodes = 0;
        for(int serverId = 0; serverId<serverMap.size();serverId++) {
            totalVNodes += serverMap.get(serverId).size();
            serverMap.get(serverId).clear();
        }
        return roundRobinVNodesToServers(totalVNodes, serverMap);
    }

    private int roundRobinVNodesToServers(int numVNodes, HashMap<Integer, ArrayList<Integer>> serverMap){
        if(numVNodes <= 0) return FAILURE;
        if(serverMap == null) return FAILURE;
        int activeServers = serverMap.size();
        if(activeServers <= 0) return FAILURE;
        int vNodes_per_Server = numVNodes/activeServers;
        if(vNodes_per_Server <= 0) return FAILURE;
        for(int vNode=0; vNode<numVNodes; vNode++){
            serverMap.get(vNode/vNodes_per_Server).add(vNode);
        }
        return SUCCESS;
    }
}
