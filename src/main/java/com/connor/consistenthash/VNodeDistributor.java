package com.connor.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;

public interface VNodeDistributor {
    public static int SUCCESS = 200;
    public static int FAILURE = 400;
    abstract int addServer(int serverId, HashMap<Integer, ArrayList<Integer>> serverMap);
    abstract int removeServer(int serverId, HashMap<Integer, ArrayList<Integer>> serverMap);
    abstract int firstTimeDistributeVNodesToServers(final int totalVNodes, HashMap<Integer, ArrayList<Integer>> serverMap);
    abstract int reBalanceExistingVNodesAcrossServers(final int totalVNodes, HashMap<Integer, ArrayList<Integer>> serverMap);
}
