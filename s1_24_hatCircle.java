import java.util.*;
public class s1_24_hatCircle {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int halfN = n/2;
        int[] circ1 = new int[halfN];

        for(int i = 0; i < halfN; i++) {
            circ1[i] = Integer.parseInt(sc.nextLine());
        }
        for(int i = 0; i < halfN; i++) {
            int curr = Integer.parseInt(sc.nextLine());
            if(curr == circ1[i]) {
                count++;
            }
        }
        System.out.println(count*2);
    }
}
