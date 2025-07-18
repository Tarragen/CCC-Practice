import java.util.*;
import java.io.*;

public class s4_07_waterPark {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Set<Integer>> connectionsUp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int inputs = readInt();
        int[][] dp = new int[inputs+1][inputs+1];

        while(true){
            int a = readInt(), b = readInt();
            if(a==0 && b == 0) break;
            connectionsUp.computeIfAbsent(b, e->new HashSet<>()).add(a);

        }
        dp[1][0] = 1;

        for(int i = 2; i <= inputs; i++) {
            Set<Integer> connections = connectionsUp.get(i);
            for(int j = 1; j< i; j++) {
                if(connections.contains(j)) {
                    dp[i][j]+=dp[j][j-1];
                }
                dp[i][j]+=dp[i][j-1];
            }
        }
        System.out.println(dp[inputs][inputs-1]);




    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

}
