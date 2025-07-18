import java.util.*;
import java.io.*;

public class s3_19_arithmeticSquare_subtask1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[][] grid = new String[3][3];
        List<int[]> xLoc = new ArrayList<>();
        List<int[]> waitList = new ArrayList<>();
        int[][] bounds = new int[][]{{0,-1,0,1}, {-1,0,1,0}};
        int[][] bounds2 = new int[][] {{0,-2,0,-1}, {0,2,0,1}, {-2,0,-1,0}, {2,0,1,0}};

        grid[0][0] = next();
        grid[0][1] = next();
        grid[0][2] = next();
        grid[1][0] = next();
        grid[1][1] = next();
        grid[1][2] = next();
        grid[2][0] = next();
        grid[2][1] = next();
        grid[2][2] = next();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j].equals("X")) {
                    xLoc.add(new int[]{i, j});
                }
            }
        }

        for(int[] i : xLoc) {
            boolean fin = false;
            int y = i[0], x = i[1];
            for(int[] j : bounds) {
                int y1 = y + j[0];
                int y2 = y + j[2];
                int x1 = x + j[1];
                int x2 = x + j[3];
                if(!(oob(y1) || oob(y2) || oob(x1) || oob(x2))) {
                    String s1 = grid[y1][x1];
                    String s2 = grid[y2][x2];
                    if(s1.equals("X") || s2.equals("X")) {
                        continue;
                    }
                    grid[y][x] = Integer.toString((Integer.parseInt(s1) + Integer.parseInt(s2))/2);
                    fin = true;
                    break;
                }
            }
            if(fin) continue;

            for(int[] j : bounds2) {
                int y1 = y + j[0];
                int y2 = y + j[2];
                int x1 = x + j[1];
                int x2 = x + j[3];
                if(!(oob(y1) || oob(y2) || oob(x1) || oob(x2))) {
                    String s1 = grid[y1][x1];
                    String s2 = grid[y2][x2];
                    if(s1.equals("X") || s2.equals("X")) {
                        continue;
                    }
                    grid[y][x] = Integer.toString(Integer.parseInt(s2)+(Integer.parseInt(s2)-Integer.parseInt(s1)));
                    fin = true;
                    break;
                }
            }
            if(!fin) {
                waitList.add(i);
            }
        }
        for(int[] i : waitList) {
            boolean fin = false;
            int y = i[0], x = i[1];
            for(int[] j : bounds) {
                int y1 = y + j[0];
                int y2 = y + j[2];
                int x1 = x + j[1];
                int x2 = x + j[3];
                if(!(oob(y1) || oob(y2) || oob(x1) || oob(x2))) {
                    String s1 = grid[y1][x1];
                    String s2 = grid[y2][x2];
                    if(s1.equals("X") || s2.equals("X")) {
                        continue;
                    }
                    grid[y][x] = Integer.toString((Integer.parseInt(s1) + Integer.parseInt(s2))/2);
                    fin = true;
                    break;
                }
            }
            if(fin) continue;

            for(int[] j : bounds2) {
                int y1 = y + j[0];
                int y2 = y + j[2];
                int x1 = x + j[1];
                int x2 = x + j[3];
                if(!(oob(y1) || oob(y2) || oob(x1) || oob(x2))) {
                    String s1 = grid[y1][x1];
                    String s2 = grid[y2][x2];
                    if(s1.equals("X") || s2.equals("X")) {
                        continue;
                    }
                    grid[y][x] = Integer.toString(Integer.parseInt(s2)+(Integer.parseInt(s2)-Integer.parseInt(s1)));
                    break;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            System.out.println(grid[i][0] + " " + grid[i][1] + " " + grid[i][2]);
        }

    }

    static boolean oob (int a) {
        return a > 2 || a < 0;
    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

}
