import java.util.*;
import java.io.*;

public class s2_20_escapeRoom_j5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Map<Integer, List<int[]>> gridLoc = new HashMap<>();
        int m = readInt(), n = readInt();
        int[][] grid = new int[m+1][n+1];
        boolean[][] visited = new boolean[m+1][n+1];

        for(int i = 1; i <= m; i++) { //initialize grid
            for(int j = 1; j <= n; j++) {
                grid[i][j] = readInt();
                gridLoc.computeIfAbsent(grid[i][j], a -> new ArrayList<>()).add(new int[]{i, j});
                //define location for each num, iterate them through bfs
            }
        }
        //generic bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{m, n});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            if(visited[i][j]) continue;
            visited[i][j] = true;
            if(i == 1 && j == 1) {
                System.out.println("yes");
                return;
            }

            int sum = i*j;

            List<int[]> correspond = gridLoc.get(sum);
            if(correspond != null) {
                queue.addAll(correspond);
                gridLoc.remove(sum);
            }

        }
        System.out.println("no");

    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }



    /*static List<List<Integer>> grid = new ArrayList<>();
    static boolean[][] visitedGrid;
    static int rows, cols;
    static Map<Integer, List<int[]>> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = Integer.parseInt(sc.nextLine());
        cols = Integer.parseInt(sc.nextLine());
        int[] playerPos = {rows, cols};
        visitedGrid = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            String[] currLine = sc.nextLine().split(" ");
            grid.add(new ArrayList<>());
            for(int j = 0; j < cols; j++) {
                int num = Integer.parseInt(currLine[j]);
                grid.get(i).add(num);
                map.computeIfAbsent(num, e -> new ArrayList<>()).add(new int[] {i+1, j+1});
            }
        }

        if(!searchBFS(playerPos)) {
            System.out.println("no");
        }
    }

    private static boolean searchBFS(int[] pos) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(pos);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if(r == 1 && c == 1) {
                System.out.println("yes");
                return true;
            }
            visitedGrid[r-1][c-1] = true;
            int res = r*c;
            List<int[]> allCoords = map.get(res);
            if(allCoords != null) {
                for (int[] coord : allCoords) {
                    int row = coord[0];
                    int col = coord[1];
                    if (!visitedGrid[row - 1][col - 1]) {
                        queue.add(new int[]{row, col});
                    }
                }
            }
            if (map != null) {
                map.remove(res);
            }
        }
        return false;
    }

    //convert to bfs tomorrow
    private static boolean searchDFS(int[] pPos) {
        if(pPos[0] == 1 && pPos[1] == 1) {
            System.out.println("yes");
            return true;
        }
        int r = pPos[0];
        int c = pPos[1];
        int res = r*c;
        for (int i = rows-1; i >= 0; i--) {
            for(int j = cols-1; j >= 0; j--) {
                if(grid.get(i).get(j) == res && !visitedGrid[i][j]) {
                    visitedGrid[i][j] = true;
                    if (searchDFS(new int[] {i+1, j+1})) {
                        return true;
                    }
                    visitedGrid[i][j] = true;
                }
            }
        }
        return false;
    }
     */
}
