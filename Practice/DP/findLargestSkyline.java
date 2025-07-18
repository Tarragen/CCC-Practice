package Practice.DP;
import java.util.*;

public class findLargestSkyline {
    public static void main(String[] args) {
        System.out.println(findLargestSkylineArea(new ArrayList<>(Arrays.asList(0, 1))));
    }

    static int findLargestSkylineArea(ArrayList<Integer> buildings) {
        int max = 0, len = buildings.size();
        if(len==0) {
            return max;
        }
        List<int[]> dp = new ArrayList<>();
        dp.add(new int[]{buildings.get(0), buildings.get(0), 1});//areas, min height, len

        for(int i = 1; i < buildings.size(); i++) {
            int curr = buildings.get(i);
            dp.add(new int[]{curr, curr, 1});

            int index = dp.size();
            for(int j = 1; j <= i; j++) {
                int[] stats = dp.get(index-1-j);
                int smallest = Math.min(curr, stats[1]);
                dp.add(new int[] {(stats[2] + 1) * smallest, smallest, stats[2] + 1});
            }
        }
        for (int[] arr : dp) {
            if(arr[0] > max) {
                max = arr[0];
            }
        }
        return max;
    }
}
