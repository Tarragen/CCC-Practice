package Contest2024;

import java.util.Scanner;

public class j3_24 {
    public static void main(String[] args) {
        int[] scoreCount = new int[76];
        int goldScore = 0;
        int silverScore = 0;
        int bronzeScore = 0;
        Scanner sc = new Scanner(System.in);
        int participants = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < participants; i++) {
            int score = Integer.parseInt(sc.nextLine());
            scoreCount[score]++;
            if(score > goldScore) {
                bronzeScore = silverScore;
                silverScore = goldScore;
                goldScore = score;
            } else if (score != goldScore){
                if(score > silverScore) {
                    bronzeScore = silverScore;
                    silverScore = score;
                } else if (score > bronzeScore && score != silverScore) {
                    bronzeScore = score;
                }
            }
        }
        System.out.println((bronzeScore + " " + scoreCount[bronzeScore]));
    }
}
