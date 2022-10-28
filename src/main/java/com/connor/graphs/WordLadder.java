package com.connor.graphs;

import java.util.*;

public class WordLadder {

    public static List<List<String>> buildAdjacencyList(List<String> wordList){
        List<List<String>> allowedMovesList = new ArrayList<>();
        for(String word:wordList){
            for(int i = 0; i < word.length(); i++){
                String allowedChar = word.substring(i, i+1);
                if(allowedMovesList.size() <= i) {
                    List<String> allowedMovesForCharIndex = new ArrayList<>();
                    // maybe linked List is better as we'll just be iterating through it, never need to index anything
                    allowedMovesForCharIndex.add(allowedChar);
                    allowedMovesList.add(i, allowedMovesForCharIndex);
                }
                else{
                    if(!allowedMovesList.get(i).contains(allowedChar)) allowedMovesList.get(i).add(allowedChar);
                    // this is set like behaviour, should I be using a set?
                }
            }
        }
        return allowedMovesList;
    }

    public static List<String> getNeighbours(String word, List<List<String>> adjacencyList, List<String> allowedWords){
        List<String> neighbours = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            List<String> allowedChars = adjacencyList.get(i);
            for(String chr:allowedChars){
                StringBuilder stringBuilder = new StringBuilder(word);
                String neighbour = stringBuilder.replace(i, i+1, chr).toString();
                if(allowedWords.contains(neighbour) && !neighbour.equals(word)) neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    public static int wordLadder(String begin, String end, List<String> wordList) {
        // bfs through every possible word (and all it's possible words) until we arrive at the target
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add(begin);
        boolean[] visited = new boolean[wordList.size()];
        visited[wordList.indexOf(begin)] = true;
        int level = 0;
        List<List<String>> adjacencyList = buildAdjacencyList(wordList);
        while (!deque.isEmpty()){
            int numberOfVerticesInLevel = deque.size();
            for(int i = 0; i < numberOfVerticesInLevel; i++){
                String currentWord = deque.poll();
                if(currentWord.equals(end)) return level;
                for(String neighbour:getNeighbours(currentWord,adjacencyList,wordList)){
                    if(visited[wordList.indexOf(neighbour)] != true){
                        deque.offer(neighbour);
                        visited[wordList.indexOf(neighbour)] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
