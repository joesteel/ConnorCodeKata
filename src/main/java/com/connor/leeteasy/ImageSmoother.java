package com.connor.leeteasy;

public class ImageSmoother {

    public static int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                result[i][j] = getNeighourhoodAverage(img,i,j);
            }
        }
        return result;
    }
    
    private static int getNeighourhoodAverage(int[][] img, int row, int col){
        int sum = 0;
        int count = 0;
        for(int y = row-1; y <= row + 1; y++){ // row by row
            if(y < 0 || y >= img.length) continue;
            for (int x = col-1; x <= col + 1; x++){ // col by col
                if(x < 0 || x >= img[0].length) continue;
                sum += img[y][x];
                count++;
            }
        }
        return sum/count;
    }
}
