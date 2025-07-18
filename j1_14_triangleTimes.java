import java.util.*;
import java.io.*;

public class j1_14_triangleTimes {
    public static void main(String[] args) {
        int ang1, ang2, ang3;
        Scanner sc = new Scanner(System.in);

        ang1 = sc.nextInt();
        ang2 = sc.nextInt();
        ang3 = sc.nextInt();

        if (ang1 + ang2 + ang3 == 180) {
            if(ang1 == ang2 && ang2 == ang3) {
                System.out.println("Equilateral");
            } else if (ang1 == ang2 || ang1 == ang3 || ang2 == ang3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }
}
