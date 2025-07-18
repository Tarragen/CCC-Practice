import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s4_15_convexHulls {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, List<Integer>> connectivity = new HashMap<>();
    static int start, end, minutes = Integer.MAX_VALUE;
    static boolean[] locked;
    static int[][] dp;
    static Queue<Integer> next = new ArrayDeque<>();
    //static List<int[]>[][] pathMatrix;

    public static void main(String[] args) throws IOException {
        int thickness = readInt(), islands = readInt(), lines = readInt();
        locked = new boolean[islands];
        //pathMatrix = new List[islands][islands];
        dp = new int[islands][thickness];

        for(int i=0; i<islands; i++) {for(int j=0; j<thickness; j++) {dp[i][j]=Integer.MAX_VALUE;}}

        int a, b, time, damage;
        for(int i = 0; i < lines; i++) {
            a = readInt(); b = readInt(); time = readInt(); damage = readInt();

            connectivity.computeIfAbsent(a, k->new ArrayList<>()).addAll(Arrays.asList(b, time, damage));
            connectivity.computeIfAbsent(b, k->new ArrayList<>()).addAll(Arrays.asList(a, time, damage));
//            if(pathMatrix[a-1][b-1] == null) pathMatrix[a-1][b-1] = new ArrayList<>();
//            if(pathMatrix[b-1][a-1] == null) pathMatrix[b-1][a-1] = new ArrayList<>();
//            pathMatrix[a-1][b-1].add(new int[]{time, damage});
//            pathMatrix[b-1][a-1].add(new int[]{time, damage});
        }
        start = readInt();
        end = readInt();

        for(int i = 0; i < thickness; i++) {
            dp[start-1][i] = 0;
        }

        List<Integer> currDict;
        int goalTime, wear, goalIsland, curr;
        int duration;
        next.add(start);
        while(!next.isEmpty()) {//thickness = 7
            curr = next.poll();//1
            locked[curr-1] = false;
            currDict = connectivity.get(curr);//2,3

            for(int i = 0; i < currDict.size(); i+=3) {
                goalIsland = currDict.get(i);
                goalTime = currDict.get(i+1);
                wear = currDict.get(i+2);

                for(int j = 0; j < thickness-wear; j++) {//0-2 or 1-3
                    duration = dp[curr-1][j];//0,0,0
                    if(duration+goalTime < dp[goalIsland-1][j+wear]) {//duration+goalTime=3 : infinity
                        dp[goalIsland-1][j+wear] = duration+goalTime;

                        if(!locked[goalIsland-1]) {
                            next.add(goalIsland);
                            locked[goalIsland-1] = true;
                        }
                    }
                }
            }
        }
        if(dp[end-1][thickness-1] != Integer.MAX_VALUE) {
            System.out.println(dp[end-1][thickness-1]);
        } else {
            System.out.println(-1);
        }





//        locked[start-1] = true;
//        dfs(0, thickness, start);
//        System.out.println(minutes == Integer.MAX_VALUE ? -1: minutes);
    }

    //dfs nor bfs works, dijkstra's is needed
//    static void dfs(int currMin, int currHealth, int currIsland) {
//        System.out.println("recursing");
//        if(currIsland == end) {
//            minutes = Math.min(minutes, currMin);
//            return;
//        }
//        int health;
//        List<Integer> others = connectivity.get(currIsland);
//        for(int i : others) {
//            if(!locked[i-1]) {
//                List<int[]> curr = pathMatrix[currIsland-1][i-1];
//                for(int[] j : curr) {
//                    health = currHealth - j[1];
//                    if(health > 0) {
//                        locked[i-1] = true;
//                        dfs(currMin+j[0], health, i);
//                        locked[i-1] = false;
//                    }
//                }
//            }
//        }
//
//    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

}
