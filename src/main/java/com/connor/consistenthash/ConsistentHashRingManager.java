package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;

public class ConsistentHashRingManager {
    private final static int FAILURE = -1;
    private VNodeDistributor distributor;
    private HashManager hashManager;
    private ArrayList<Integer> serverList;
    private HashMap<Integer, ArrayList<Integer>> servervNodeMap;
    private int totalVNodes;
    private final static int DEFAULT_RANGE = 100;

    public ConsistentHashRingManager(int numServers, int numVNodes){
        totalVNodes = numVNodes;
        serverList = new ArrayList<Integer>();
        for(int serverId = 0; serverId < numServers; serverId++ ){
            serverList.add(serverId);
        } // assuming contiguous serverIds to start with
        distributor = VNodeDistributorFactory.getDistributor("SIMPLE");
        servervNodeMap = initializeServers();
        distributor.firstTimeDistributeVNodesToServers(totalVNodes, servervNodeMap);
        hashManager = new HashManager(DEFAULT_RANGE, DEFAULT_RANGE*totalVNodes);
    }

    public int getServerForKey(final String key){
        int vNode = hashManager.getVNode(key);
        if(vNode != HashManager.HASHING_FAILURE) {
            int[] vNodeServers = createVNodeToservervNodeMapping();
            return vNodeServers[vNode];
        } else return HashManager.HASHING_FAILURE;
    }

    public int addServerToRotation(final int serverId){
        if(serverList.contains(serverId)) {
            System.out.printf("ServerId: %d already exists in rotation", serverId);
            return FAILURE;
        }
        serverList.add(serverId);
        return distributor.addServer(serverId, servervNodeMap);
    }

    public int removeServerFromRotation(final int serverId){
        if(!serverList.contains(serverId)) {
            System.out.printf("ServerId: %d does not exist in rotation", serverId);
            return FAILURE;
        }
        serverList.remove(serverId);
        return distributor.removeServer(serverId, servervNodeMap);
    }

    public int getServerCount(){ return serverList.size(); }

    private int[] createVNodeToservervNodeMapping(){
        int[] vNodeServers = new int[totalVNodes];
        for (Integer activeServer:serverList) {
            for(Integer node:servervNodeMap.get(activeServer.intValue())){
                vNodeServers[node] = activeServer.intValue();
            }
        }
        return vNodeServers;
    }

    private HashMap<Integer, ArrayList<Integer>> initializeServers(){
        HashMap<Integer, ArrayList<Integer>> servervNodeMap = new HashMap<Integer, ArrayList<Integer>>();
        serverList.forEach(server -> {
            ArrayList<Integer> list_of_vNodes_for_a_server = new ArrayList<Integer>();
            servervNodeMap.put(server, list_of_vNodes_for_a_server);
        });
        return servervNodeMap;
    }

}