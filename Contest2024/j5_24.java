package Contest2024;

import java.util.Scanner;

public class j5_24 {
    static char[][] grid;
    static boolean[][] used;
    static int[] pos;
    static final int lVal = 10, mVal = 5, sVal = 1;
    static int r, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = Integer.parseInt(sc.nextLine());
        c = Integer.parseInt(sc.nextLine());
        pos = new int[2];
        grid = new char[r][c];
        used = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            char[] line = sc.nextLine().toCharArray();
            grid[i] = line;
        }
        pos[0] = Integer.parseInt(sc.nextLine());
        pos[1] = Integer.parseInt(sc.nextLine());
        int total = searchVal(pos);
        System.out.println(total);
    }

    public static int searchVal(int[] coords) {
        int total = 0;
        int y = coords[0];
        int x = coords[1];
        char curr = grid[y][x];
        if(curr == '*') {
            return 0;
        }

        if(curr == 'L') {
            total += lVal;
        } else if (curr == 'M') {
            total += mVal;
        } else {
            total += sVal;
        }
        used[y][x] = true;

        int go1 = y-1;
        int go2 = y+1;
        int go3 = x-1;
        int go4 = x+1;

        if(!OOB(go1, r -1) && !used[go1][x]) {
            total += searchVal(new int[] {go1, x});
        }
        if(!OOB(go2, r -1) && !used[go2][x]) {
            total += searchVal(new int[] {go2, x});
        }
        if(!OOB(go3, c -1) && !used[y][go3]) {
            total += searchVal(new int[] {y, go3});
        }
        if(!OOB(go4, c -1) && !used[y][go4]) {
            total += searchVal(new int[] {y, go4});
        }
        return total;
    }



    private static boolean OOB(int num, int high) {
        return num < 0 || num > high;
    }
}
