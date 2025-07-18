package Practice.DP;
import java.util.*;

public class staircaseTraversal {
    public static void main(String[] args) {
        System.out.println(climbStairs(4,2));
    }

    static int climbStairs (int totalStairs, int stepsAllowed) {
        Map<Integer, Integer> memo = new HashMap<>();
        return recurse(totalStairs, stepsAllowed, memo);
    }

    static int recurse(int totalStairs, int stepsAllowed, Map<Integer, Integer> memo) {
        if (totalStairs == 0) return 1;
        if (totalStairs < 0) return 0;
        if (memo.containsKey(totalStairs)) {
            return memo.get(totalStairs);
        }

        int way = 0;
        for (int step = 1; step <= stepsAllowed; step++) {
            way += recurse(totalStairs - step, stepsAllowed, memo);
        }
        memo.put(totalStairs, way);

        return way;
    }
}
