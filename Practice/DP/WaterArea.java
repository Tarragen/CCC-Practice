package Practice.DP;
import java.util.*;

public class WaterArea {
    public static void main(String[] args) {
        System.out.println(findWaterArea(new int[]{0, 100, 0, 0, 10, 1, 1, 10, 1, 0, 1, 1, 0, 0}));
    }

    static int findWaterArea(int[] heights) {
        if(heights.length < 3) {
            return 0;
        }
        int area = 0;
        int n = heights.length;
        int[] leftSize = new int[n-1];
        int[] rightSize = new int[n-1];

        int high = 0;

        for(int i = 0; i < heights.length-1; i++) {
            if(heights[i] > high) {
                high = heights[i];
            }
            leftSize[i] = high;
        }
        high = 0;
        for(int i = heights.length-1; i>0; i--) {
            if(heights[i] > high) {
                high = heights[i];
            }
            rightSize[i-1] = high;
        }

        for(int i = 1; i < heights.length-1; i++) {
            int l = leftSize[i-1], r =rightSize[i];
            if(heights[i] >= l || heights[i] >= r) continue;

            area+=Math.min(l,r)-heights[i];
        }

        return area;
    }
}
