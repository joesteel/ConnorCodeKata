package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;

public class ConsistentHashRingManager {
    private final static int FAILURE = -1;
    private VNodeDistributor distributor;
    private HashManager hashManager;
    private ArrayList<Integer> serverList;
    private HashMap<Integer, ArrayList<Integer>> serverMap;
    private int totalVNodes;
    private final static int DEFAULT_RANGE = 100;

    public ConsistentHashRingManager(int numServers, int numVNodes){
        totalVNodes = numVNodes;
        serverList = new ArrayList<Integer>();
        for(int serverId = 0; serverId < numServers; serverId++ ){
            serverList.add(serverId);
        }
        distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        serverMap = initializeServers(numServers);
        distributor.firstTimeDistributeVNodesToServers(totalVNodes, serverMap);
        hashManager = new HashManager(DEFAULT_RANGE, DEFAULT_RANGE*totalVNodes);
    }

    public int getServerForKey(final String key){
        int hashingResult = hashManager.getVNode(key);
        if(hashingResult != HashManager.HASHING_FAILURE) {
            int[] vNodes = createVNodeToServerMapping();
            return vNodes[hashingResult];
        }
        else return HashManager.HASHING_FAILURE;
    }

    public int addServerToRotation(final int serverId){
        if(serverList.contains(serverId)) {
            System.out.printf("ServerId: %d already exists in rotation", serverId);
            return FAILURE;
        }
        serverList.add(serverId);
        return distributor.addServer(serverId, serverMap);
    }

    public int removeServerFromRotation(final int serverId){
        if(!serverList.contains(serverId)) {
            System.out.printf("ServerId: %d does not exist in rotation", serverId);
            return FAILURE;
        }
        serverList.remove(serverId);
        return distributor.removeServer(serverId, serverMap);
    }

    public int getServerCount(){ return serverList.size(); }

    private int[] createVNodeToServerMapping(){
        int[] vNodeServers = new int[totalVNodes];
        for (Integer activeServer:serverList) {
            for(Integer node:serverMap.get(activeServer.intValue())){
                vNodeServers[node] = activeServer.intValue();
            }
        }
        return vNodeServers;
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

