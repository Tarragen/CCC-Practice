import java.util.*;
public class j2_21_silentAuction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buyers = Integer.parseInt(sc.nextLine());
        int highestBid = Integer.MIN_VALUE;
        String highestBuyer = null;

        for (int i = 0; i < buyers; i++) {
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());
            
            if(price > highestBid) {
                highestBid = price;
                highestBuyer = name;
            }
        }
        System.out.println(highestBuyer);
    }
}
