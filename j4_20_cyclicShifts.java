import java.util.*;
public class j4_20_cyclicShifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String text = sc.nextLine();
        final String pattern = sc.nextLine();

        for (int i = 0; i < pattern.length(); i++) {
            String curr = pattern.substring(i) + pattern.substring(0, i);
            if(text.contains(curr)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }
}
