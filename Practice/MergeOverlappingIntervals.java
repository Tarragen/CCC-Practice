package Practice;
import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][]res = mergeOverlappingIntervals(new int[][] {{1,2},{2,3},{1,4},{6,7},{8,10}, {1,5}});
        for(int[] i : res) {
            System.out.println(i[0] + ", " + i[1]);
        }
    }

    //[1,2], [1,4], [2,3], [6,7], [8,10]
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[][]{};
        }
        List<int[]> handler = new ArrayList<>(Arrays.asList(intervals));
        handler.sort((a,b)->Integer.compare(a[0], b[0]));

        for(int i = 0; i < handler.size()-1; i++) {
            int[] curr = handler.get(i);
            int[] next = handler.get(i+1);
            if(next[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], next[1]);
                handler.remove(i+1);
                i--;
            }
        }

        return handler.toArray(new int[0][]);
    }
}
