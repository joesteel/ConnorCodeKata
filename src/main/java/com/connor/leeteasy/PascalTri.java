package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.List;

public class PascalTri {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> first_row = new ArrayList<>(1);
        first_row.add(1);
        result.add(first_row);

        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            List<Integer> previous_row = result.get(i-1);

            for(int j = 1; j < i; j++){
                row.add(previous_row.get(j-1) + previous_row.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
