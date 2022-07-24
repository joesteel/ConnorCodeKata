package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;

public interface VNodeDistributor {
    public static int SUCCESS = 200;
    public static int FAILURE = 400;
    abstract int addServer(HashMap<Integer, ArrayList<Integer>> serverMap);
    abstract int removeServer(int serverId, HashMap<Integer, ArrayList<Integer>> serverMap);
    abstract int distributeVNodesToServers(HashMap<Integer, ArrayList<Integer>> serverMap, int VNodes);
    abstract int reBalanceExistingVNodesAcrossServers(HashMap<Integer, ArrayList<Integer>> serverMap);
}


