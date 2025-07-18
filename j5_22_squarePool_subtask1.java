import java.util.*;
public class j5_22_squarePool_subtask1 {
    public static void main(String[] args) {
        int largest;
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int treeCount = Integer.parseInt(sc.nextLine());
        int[][] treeList = new int[treeCount][2];

        for(int i = 0; i < treeCount; i++) {
            String[] coords = sc.nextLine().split(" ");
            int r = Integer.parseInt(coords[0]);
            int c = Integer.parseInt(coords[1]);

            treeList[i][0] = r;
            treeList[i][1] = c;
        }
        int r = treeList[0][0];
        int c = treeList[0][1];
        //|| Math.abs(m-r) == Math.abs(1-c)
        if(r == c) {
            largest = Math.max(Math.abs(m-r), Math.abs(1-r));
        } else {
            largest = Math.max(Math.max(m-r, m-c), Math.max(r-1, c-1));
        }

        System.out.println(largest);
    }
}
