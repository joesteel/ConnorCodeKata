package com.connor.leeteasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTri2 {
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex < 1) return null;
        List<Integer> previousRow = null;
        List<Integer> currentRow = new ArrayList<>(Arrays.asList(1));
        for(int i = 1; i < rowIndex; i++){
            previousRow = currentRow;
            currentRow = new ArrayList<>(i);
            currentRow.add(1);
            for(int j = 1; j < i; j++){
                currentRow.add(previousRow.get(j-1) + previousRow.get(j));
            }
            currentRow.add(1);
        }
        return currentRow;
    }
}
