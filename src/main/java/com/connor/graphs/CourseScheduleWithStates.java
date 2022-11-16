package com.connor.graphs;

import java.util.*;

public class CourseScheduleWithStates {

    private enum State{
        VISITED, VISITING, TO_VISIT
    }

    public static Map<Integer, List<Integer>> createGraph(List<List<Integer>> dependencies){
        Map<Integer, List<Integer>> graph = new HashMap<>(dependencies.size());
        dependencies.forEach(dependencyPair -> {
            graph.computeIfAbsent(dependencyPair.get(0), k-> new ArrayList<>()).add(dependencyPair.get(1));
        });
        return graph;
    }

    public static boolean dfs( Map<Integer, List<Integer>> graph, int current, State[] states){
        states[current] = State.VISITING;
        if(graph.get(current) != null) {
            for(int child: graph.get(current)){
                if(states[child] == State.VISITED) continue;
                else if(states[child] == State.VISITING) return false;
                else {
                    return dfs(graph, child, states);
                }
            }
        }
        states[current] = State.VISITED;
        return true;
    }

    public static boolean isValidCourseSchedule(int n, List<List<Integer>> prerequisites) {
        Map<Integer, List<Integer>> graph = createGraph(prerequisites);
        State[] states = new State[n];
        Arrays.fill(states, State.TO_VISIT);
        boolean result = true;
        for(int i = 0; i < n; i++){
            result = result && dfs(graph, i, states);
        }
        return result;
    }

}
