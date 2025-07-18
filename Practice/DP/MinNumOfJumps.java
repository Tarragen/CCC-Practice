package Practice.DP;
import java.util.*;

public class MinNumOfJumps {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        System.out.println(kms(arr));
    }

    public static int kms(int[] jumps) {
        int len = jumps.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for(int i = 1; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < len-1; i++) {
            int jmp = jumps[i];
            for(int j = 1; j<=jmp; j++) {
                if(i+j >= len) {
                    return dp[len-1];
                }
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[len-1];
    }
}
