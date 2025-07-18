import java.text.DecimalFormat;
import java.util.*;
public class j2_24_mock_eloRating {
    public static void main(String[] args) {
        DecimalFormat fm = new DecimalFormat("#.#");
        Scanner sc = new Scanner(System.in);
        String[] l1 = sc.nextLine().split(" ");
        String[] results = sc.nextLine().split("");

        int games = Integer.parseInt(l1[0]);
        double p1 = Integer.parseInt(l1[1]);
        double p2 = Integer.parseInt(l1[2]);
        int k = Integer.parseInt(l1[3]);


        for(int i = 0; i < games; i++) {
            double score1 = 0, score2 = 0;
            String res = results[i];
            if(res.equals("T")) {
                score1 += 0.5;
                score2 += 0.5;
            } else if(res.equals("L")) {
                score2++;
            } else if (res.equals("W")) {
                score1++;
            }
            double expect1 = 1/(Math.pow(10, (p2 - p1)/400) + 1);
            double expect2 = 1/(Math.pow(10, (p1 - p2)/400) + 1);

            p1 = p1 + ((score1-expect1)*k);
            p2 = p2 + ((score2-expect2)*k);
            System.out.println(fm.format(p1) + " " + fm.format(p2));

        }
    }
}
