package Practice.DP;

import java.util.*;
public class NumOfWaysToTraverseGraph {
    public static void main(String[] args) {
        System.out.println(traverse(7, 6));
    }

    public static int traverse(int height, int width) {
        int[][] dp = new int[height][width];

        for(int i = 1; i < width; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i < height; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i< height; i++) {
            for(int j = 1; j < width; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[height-1][width-1];
    }
}
