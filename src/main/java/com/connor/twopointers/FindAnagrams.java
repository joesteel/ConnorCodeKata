package com.connor.twopointers;

import java.util.*;
import java.util.stream.Collectors;

public class FindAnagrams {

    public static List<Integer> findAllAnagrams(String original, String check) {
        int left = 0, right = check.length()-1;
        List<Integer> result = new ArrayList<>();
        String sortedCheck = check
                .codePoints()
                .mapToObj(x->String.valueOf(x))
                .sorted()
                .collect(Collectors.joining());
        while(right < original.length()){
            String sortedWindow = original
                    .substring(left, right+1)
                    .codePoints()
                    .mapToObj(x->String.valueOf(x))
                    .sorted()
                    .collect(Collectors.joining());
            if(sortedWindow.equals(sortedCheck)) result.add(left);
            left++;right++;
        }
        return result;
    }
}
