import java.util.*;

public class j5s2_21_modernArt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int squaresPainted = 0;
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        int choices = Integer.parseInt(sc.nextLine());

        int[] strokeRow = new int[rows];
        int[] strokeCol = new int[cols];

        for(int i = 0; i < choices; i++) {
            String[] choice = sc.nextLine().split(" ");
            String dir = choice[0];
            int location = Integer.parseInt(choice[1]) - 1;

            if(dir.equals("R")) {
                strokeRow[location]+=1;
            } else {
                strokeCol[location]+=1;
            }
        }
        sc.close();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if((strokeRow[i] + strokeCol[j]) % 2 == 1) {
                    squaresPainted++;
                }
            }
        }
        System.out.println(squaresPainted);
    }
}
