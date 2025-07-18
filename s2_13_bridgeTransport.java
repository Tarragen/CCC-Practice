import java.util.*;
public class s2_13_bridgeTransport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int passableCarts = 0;
        int maxWeight = Integer.parseInt(sc.nextLine());
        int cartNum = Integer.parseInt(sc.nextLine());
        int[] carts = new int[cartNum];
        for(int i = 0; i < cartNum; i++) {
            carts[i] = Integer.parseInt(sc.nextLine());
        }
        int total = 0;
        int j = 0;
        for(int i = 0; i < cartNum; i++) {
            total += carts[i];
            if(j == 4) {
                total-= carts[i-4];
            }
            if(total <= maxWeight) {
                passableCarts++;
            } else {
                break;
            }
            if(j<4) {
                j++;
            }
        }
        System.out.println(passableCarts);
    }
}
