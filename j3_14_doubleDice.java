import java.util.*;
import java.io.*;

public class j3_14_doubleDice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int score1 = 100, score2 = 100;
        int rolls = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rolls; i++) {
            String[] row = sc.nextLine().split(" ");
            int roll1 = Integer.parseInt(row[0]);
            int roll2 = Integer.parseInt(row[1]);

            if(roll1 > roll2) {
                score2 -= roll1;
            } else if (roll2 > roll1) {
                score1 -= roll2;
            }
        }
        System.out.println(score1);
        System.out.println(score2);
    }
}
