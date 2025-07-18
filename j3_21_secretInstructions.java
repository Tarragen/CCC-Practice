import java.util.*;
public class j3_21_secretInstructions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean turnRight = false;
        String curr;

         while (true){
             curr = sc.nextLine();
             if(curr.equals("99999")) {break;}

             int twoDigitSum = Integer.parseInt(curr.substring(0, 1)) +
                     Integer.parseInt(curr.substring(1, 2));

             if(twoDigitSum % 2 == 1) {
                 turnRight = false;
             } else if (twoDigitSum == 0) {
             } else {
                 turnRight = true;
             }

             System.out.println((turnRight ? "right" : "left") +" "+ curr.substring(2));
        }
    }
}
