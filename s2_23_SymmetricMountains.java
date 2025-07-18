import java.io.*;
import java.util.*;

public class s2_23_SymmetricMountains {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //! dp
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] mountains = new int[n];
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            mountains[i] = readInt();
        }
        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int l = 0, r = i;
            while(r < n) {
                int res = Math.abs(mountains[l] - mountains[r]) + (l + 2 < r? arr[l+1][r-1]: 0);
                arr[l][r] = res;
                if(res < min) {
                    min = res;
                }
                l++;
                r++;
            }
            System.out.print(min);
            if(i != n-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
