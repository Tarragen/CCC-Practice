import java.util.*;
public class j4_16_arrivalTime {
    public static void main(String[] args) {
        int rush1Start = 7*60;
        int rush1End = 10*60;
        int rush2Start = 15*60;
        int rush2End = 19*60;
        Scanner sc = new Scanner(System.in);
        String[] timeInput = sc.nextLine().split(":");
        int[] time = new int[] {Integer.parseInt(timeInput[0]), Integer.parseInt(timeInput[1])};

        int startTime = time[0]*60 + time[1];
        int commuteTime = 2*120;

        while(commuteTime > 0) {
            if(inRange(startTime, rush1Start, rush1End)) {
                commuteTime--;
            } else if (inRange(startTime, rush2Start, rush2End)) {
                commuteTime--;
            } else {
                commuteTime-=2;
            }
            startTime++;
        }
        if(startTime % 10 == 9) { //counters inherent flaw
            startTime++;
        }

        displayTime(startTime/60, startTime%60);
    }

    //exclusive probably
    private static boolean inRange(int num, int low, int high) {
        return num > low && num < high;
    }

    private static void displayTime(int hour, int min) {
        if(hour > 23) {
            hour-= 24;
        }
        if(hour < 10) {
            System.out.print("0" + hour);
        } else {
            System.out.print(hour);
        }
        System.out.print(":");
        if (min == 0) {
            System.out.print("00");
        } else {
            System.out.print(min);
        }
    }
}
