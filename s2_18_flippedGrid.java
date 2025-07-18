import java.util.*;



public class s2_18_flippedGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int[][] grid = new int[rows][rows];
        List<List<Integer>> transformedGrid = new ArrayList<>();

        for(int i = 0; i < rows; i++) {
            String[] input = sc.nextLine().split(" ");
            for(int j = 0; j < rows; j++) {
                grid[i][j] = Integer.valueOf(input[j]);
            }
        }
        sc.close();

        int flippedDegree = 0;
        int angle1 = grid[0][0];
        int angle2 = grid[rows-1][0];
        int angle3 = grid[0][rows-1];

        if(angle1 > angle3 && angle1 > angle2) {
            flippedDegree = 2;
        } else if (angle1 > angle3) {
            flippedDegree = 1;
        } else if (angle1 > angle2) {
            flippedDegree = 3;
        }

        if(flippedDegree == 1) { //90 degrees
            for (int i = 0; i < rows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < rows; j++) {
                    row.add(grid[j][rows-i-1]);
                }
                transformedGrid.add(row);
            }
        } else if(flippedDegree == 2) {
            for (int i = 0; i < rows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < rows; j++) {
                    row.add(grid[rows-i-1][rows-j-1]);
                }
                transformedGrid.add(row);
            }
        } else if (flippedDegree == 3) {
            for (int i = 0; i < rows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < rows; j++) {
                    row.add(grid[rows-j-1][i]);
                }
                transformedGrid.add(row);
            }
        } else {
            for (int i = 0; i < rows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < rows; j++) {
                    row.add(grid[i][j]);
                }
                transformedGrid.add(row);
            }
        }

        System.out.println();
        for(List<Integer> row : transformedGrid) {
            for(int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}