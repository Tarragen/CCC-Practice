import java.util.*;
public class j1_24_mock_lemonBathtub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        System.out.println(total/k + (total % k > 0 ? 1 : 0));
    }
}
