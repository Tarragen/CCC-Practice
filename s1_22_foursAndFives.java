import java.util.*;
public class s1_22_foursAndFives {
    public static void main(String[] args) {
        int ways = 0;
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while (num > 0) {
            if(num % 5 == 0) {
                ways++;
            }
            num -= 4;
        }
        System.out.println(ways);
    }
}
