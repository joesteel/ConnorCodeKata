package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleVNodeDistributor implements VNodeDistributor{

    SimpleVNodeDistributor(){
    }

    public int addServer(HashMap<Integer, ArrayList<Integer>> serverMap){
         return 0;
     }

    public int removeServer(int serverId, HashMap<Integer, ArrayList<Integer>> serverMap){
        return 0;
    }

    public int distributeVNodesToServers(HashMap<Integer, ArrayList<Integer>> serverMap, int VNodes){
        if(VNodes <= 0) return FAILURE;
        if(serverMap == null) return FAILURE;
        int num_servers = serverMap.size();
        if(num_servers <= 0) return FAILURE;
        int vNodes_per_Server = VNodes/num_servers;
        if(vNodes_per_Server <= 0) return FAILURE;
        for(int i=0; i<num_servers; i++){
            if(!serverMap.get(i).isEmpty()){
                System.out.printf("Server %d already has VNodes, aborting operation", i);
                return FAILURE;
            }
        }
        for(int i=0; i<VNodes; i++){
            serverMap.get(i/vNodes_per_Server).add(i);
        }
        return SUCCESS;
    }

    public int reBalanceExistingVNodesAcrossServers(HashMap<Integer, ArrayList<Integer>> serverMap){
        return 0;
    }
}
