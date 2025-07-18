import java.util.*;

public class j5_23_wordSearch {
    private static String word;
    private static int rows, cols;
    private static String[][] grid;
    private static int[][] squaresAround = {{-1,-1}, {-1,0}, {-1,1}, {0,1},
            {1,1}, {1,0},{1,-1},{0,-1}};
    private static int encountered = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine();
        String sentinel = word.substring(0,1);
        rows = Integer.parseInt(sc.nextLine());
        cols = Integer.parseInt(sc.nextLine());
        grid = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] currRow = sc.nextLine().split(" ");
            grid[i] = currRow;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if(grid[i][j].equals(sentinel)) {
                    for(int x = 0; x < squaresAround.length; x++) {
                        int yPos = i + squaresAround[x][0];
                        int xPos = j + squaresAround[x][1];
                        if(!OOB(yPos, 0, rows -1) && !OOB(xPos, 0, cols -1)) {
                            if(grid[yPos][xPos].equals(word.substring(1,2))) {
                                searchWord(yPos, xPos, x, true, word.substring(2));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(encountered);

    }

    private static void searchWord(int row, int col, int direction, boolean canDeviate, String sequenceLeft) {
        if (sequenceLeft.isEmpty()) {//base case
            encountered++;
            return;
        }

        String next = sequenceLeft.substring(0,1);
        String remaining = sequenceLeft.substring(1);
        int[] noTurn = squaresAround[direction];
        int yPos1 = row+noTurn[0];
        int xPos1 = col+noTurn[1];
        if(!OOB(yPos1, 0, rows-1) && !OOB(xPos1, 0, cols-1)) { //if valid
            if(grid[yPos1][xPos1].equals(next))
                searchWord(yPos1, xPos1, direction, canDeviate, remaining);
        }

        if(canDeviate) {
            int dev90 = direction+2>7 ? direction+2-8: direction+2;
            int dev270 = direction-2<0 ? direction-2+8 : direction-2;
            int[] turn90 = squaresAround[dev90];
            int[] turn270 = squaresAround[dev270];

            int yPos2 = row + turn90[0];
            int xPos2 = col + turn90[1];
            int yPos3 = row + turn270[0];
            int xPos3 = col + turn270[1];

            if(!OOB(yPos2, 0, rows-1) && !OOB(xPos2, 0, cols-1)) {
                if(grid[yPos2][xPos2].equals(next))
                    searchWord(yPos2, xPos2, dev90, false, remaining);
            }
            if(!OOB(yPos3, 0, rows-1) && !OOB(xPos3, 0, cols-1)) {
                if(grid[yPos3][xPos3].equals(next))
                    searchWord(yPos3, xPos3, dev270, false, remaining);
            }
        }
    }

    private static boolean OOB(int val, int low, int high) {
        return val < low || val > high;
    }
}
