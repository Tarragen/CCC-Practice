import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s4_16_combiningRiceballs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] riceballs = new int[n];
        long[] prefixSum = new long[n + 1];
        
        // Read input and calculate prefix sums
        for (int i = 0; i < n; i++) {
            riceballs[i] = readInt();
            prefixSum[i + 1] = prefixSum[i] + riceballs[i];
        }

        // dp[i][j] stores the size of valid riceball combination from index i to j
        // if dp[i][j] is 0, no valid combination exists for that range
        long[][] dp = new long[n][n];

        // Initialize single riceballs
        for (int i = 0; i < n; i++) {
            dp[i][i] = riceballs[i];
        }

        // Try all possible lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                // Try combining two adjacent groups
                for (int k = i; k < j; k++) {
                    if (dp[i][k] > 0 && dp[k + 1][j] > 0) {
                        long sum1 = getSum(prefixSum, i, k);
                        long sum2 = getSum(prefixSum, k + 1, j);
                        if (sum1 == sum2) {
                            dp[i][j] = sum1 + sum2;
                        }
                    }
                }

                // Try combining three groups
                for (int k = i + 1; k < j - 1; k++) {
                    if (dp[i][k - 1] > 0 && dp[k][k] > 0 && dp[k + 1][j] > 0) {
                        long sum1 = getSum(prefixSum, i, k - 1);
                        long sum3 = getSum(prefixSum, k + 1, j);
                        if (sum1 == sum3) {
                            dp[i][j] = sum1 + sum3 + getSum(prefixSum, k, k);
                        }
                    }
                }
            }
        }

        // Find maximum riceball size
        long maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        System.out.println(maxSize);
    }

    // Helper method to get sum of range [i,j] using prefix sums
    private static long getSum(long[] prefixSum, int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
