import java.util.*;
public class j4_01_spirals_s2 {
    public static void main(String[] args) {
        int[][] grid;
        Scanner sc = new Scanner(System.in);
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());

        int diff = end - start + 1;
        int square = (int) Math.sqrt(diff);
        int height =  diff/square + (diff%square > 0 ? 1 : 0);
        int width = diff/square + ((diff-height)%square > 0 ? 1 : 0);
        grid = new int[height][width];
        int[] pos = {(height+1)/2-1, (width+1)/2-1};

        int way = 0;
        int lenTimes = 0;
        int lenProgress = 0;
        int len = 1;
        for(int i = start; i <= end; i++) {
            if(lenTimes > 1) {
                lenTimes = 0;
                len++;
            }
            if(i == start) {
                grid[pos[0]][pos[1]] = i;
                continue;
            }
            switch(way) {
                case 0 :
                    pos[0]+=1;
                    break;
                case 1 :
                    pos[1]+=1;
                    break;
                case 2 :
                    pos[0]-=1;
                    break;
                case 3 :
                    pos[1]-=1;
                    break;
            }
            grid[pos[0]][pos[1]] = i;
            lenProgress++;
            if(lenProgress == len) {
                lenProgress = 0;
                lenTimes++;
                way++;
                if (way > 3) {
                    way = 0;
                }
            }
        }

        //display
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 0) {
                    System.out.print("   ");
                    continue;
                }
                if (ints[j] < 10) {
                    System.out.print(" ");
                }
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
