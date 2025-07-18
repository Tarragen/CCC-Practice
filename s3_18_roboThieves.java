import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s3_18_roboThieves {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] steps;
    static boolean[][] walked;
    static boolean[][] cameraSquares;
    static char[][] grid;
    static int startX = 0, startY = 0;
    static int n, m;


    public static void main(String[] args) throws IOException {
        n = readInt(); m = readInt();
        grid = new char[n][m];
        cameraSquares = new boolean[n][m];
        walked = new boolean[n][m];
        steps = new int[n][m];

        List<int[]> emptyLoc = new ArrayList<>();
        List<int[]> cameraLoc = new ArrayList<>();

        //read input
        for(int i = 0; i < n; i++) {
            String line = readLine();
            for(int j = 0; j < m; j++) {
                char curr = line.charAt(j);
                grid[i][j] = curr;
                if(curr == 'C') {
                    cameraLoc.add(new int[]{i, j});
                } else if (curr == '.') {
                    emptyLoc.add(new int[]{i, j});
                } else if (curr == 'S') {
                    startY = i; startX = j;
                }
            }
        }
        //set up camera denied squares
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] cam : cameraLoc) {
            int x = cam[1], y = cam[0];
            cameraSquares[y][x] = true;
            for (int[] dir : directions) {
                int nx = x, ny = y;
                while (true) {
                    nx += dir[1];
                    ny += dir[0];
                    char curr = grid[ny][nx];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || curr == 'W' || curr == 'C') break;
                    if(curr == 'R' || curr == 'L' || curr == 'U' || curr == 'D') {
                        continue;
                    }
                    cameraSquares[ny][nx] = true;
                }
            }
        }

        if(cameraSquares[startY][startX]) {
            //!case of robot spawning under supervision
            for(int i = 0; i < emptyLoc.size(); i++) {
                System.out.println(-1);
            }
            return;
        }


        bfsFlood();
        for(int[] i : emptyLoc) {
            int y = i[0], x = i[1];
            int ans = steps[y][x];
            System.out.println(ans==0?-1:ans);
        }
    }

    static void bfsFlood(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});

        int stepsTaken = 0;

        while(!queue.isEmpty()) {
            Queue<int[]> newQueue = new ArrayDeque<>();
            for (int[] coord : queue) {//is definitely valid
                int x = coord[0], y = coord[1];
                if(walked[y][x]) continue;
                int mod1 = y-1, mod2 = y+1, mod3 = x-1, mod4 = x+1;
                walked[y][x] = true;
                steps[y][x]=stepsTaken;
                if(y > 0 && !walked[mod1][x] && grid[mod1][x] != 'W' && !cameraSquares[mod1][x]) {
                    newQueue.add(new int[]{x, mod1});
                }
                if(y < n-1 && !walked[mod2][x] && grid[mod2][x] != 'W' && !cameraSquares[mod2][x]) {
                    newQueue.add(new int[]{x, mod2});
                }
                if(x > 0 && !walked[y][mod3] && grid[y][mod3] != 'W' && !cameraSquares[y][mod3]) {
                    newQueue.add(new int[]{mod3, y});
                }
                if(x < m-1 && !walked[y][mod4] && grid[y][mod4] != 'W' && !cameraSquares[y][mod4]) {
                    newQueue.add(new int[]{mod4, y});
                }
            }
            stepsTaken++;
            queue = newQueue;
        }

    }


    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
