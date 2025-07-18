import java.util.*;
public class j3_23_specialEvent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> attendableDays = new ArrayList<>();
        int maxDay = Integer.MIN_VALUE;
        int people = Integer.parseInt(sc.nextLine());
        char[][] scheduleList = new char[people][5];

        for (int i = 0; i < people; i++) {
            char[] schedule = sc.nextLine().toCharArray();
            scheduleList[i] = schedule;
        }

        for(int j = 0; j < 5; j++) {
            int sum = 0;
            for(int i = 0; i < people; i++) {
                if(scheduleList[i][j] == 'Y') {
                    sum++;
                }
            }
            attendableDays.add(sum);
            if(sum > maxDay) {
                maxDay = sum;
            }
        }
        boolean temp = false;
        for (int i = 0; i < attendableDays.size(); i++) {
            if(attendableDays.get(i) == maxDay) {
                if(!temp) {
                    temp = true;
                    System.out.print(i+1);
                } else {
                    System.out.print("," + (i+1));
                }
            }
        }
    }
}
