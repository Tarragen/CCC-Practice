import java.util.*;
public class j2_14_voteCount {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String countString = sc.nextLine();

        for (int i = 0; i < num; i++) {
            if (countString.charAt(i) == 'A') {
                count++;
            } else {
                count--;
            }
        }
        if(count > 0) {
            System.out.println('A');
        } else if(count < 0) {
            System.out.println('B');
        } else {
            System.out.println("Tie");
        }
    }

}
