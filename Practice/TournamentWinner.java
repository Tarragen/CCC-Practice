package Practice;
import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {
        String[][] comp = {{"HTML", "C"}, {"C", "Python"}, {"Python", "HTML"}};
        int res[] = {0, 0, 1};
        System.out.println(determine(comp, res));
    }

    public static String determine(String[][] competitions, int[] results) {
        Map<String, Integer> log = new HashMap<>();
        String leading = "";
        int max = 0;
        for(int i = 0; i < results.length; i ++) {
            String pair[] = new String[2];
            pair[1] = competitions[i][0]; pair[0] = competitions[i][1];

            int num = 3+log.getOrDefault(pair[results[i]], 0);
            if(num > max) {
                max = num;
                leading = pair[results[i]];
            }
            log.putIfAbsent(pair[results[i]], num);
        }
        return leading;
    }
}
