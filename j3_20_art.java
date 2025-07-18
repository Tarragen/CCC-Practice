import java.util.*;

public class j3_20_art {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowX = Integer.MAX_VALUE;
        int highX = Integer.MIN_VALUE;
        int lowY = Integer.MAX_VALUE;
        int highY = Integer.MIN_VALUE;

        int dots = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < dots; i++) {
            String[] coord = sc.nextLine().split(",");
            int y = Integer.parseInt(coord[1]);
            int x = Integer.parseInt(coord[0]);
            if(y > highY) {
                highY = y;
            }
            if(y < lowY) {
                lowY = y;
            }
            if(x < lowX) {
                lowX = x;
            }
            if(x > highX) {
                highX = x;
            }
        }
        System.out.println(Math.max(0, lowX-1) + "," + Math.max(0, lowY-1));
        System.out.println((highX+1) + "," + (highY+1));
    }
}


