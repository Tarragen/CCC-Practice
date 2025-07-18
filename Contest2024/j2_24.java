package Contest2024;

import java.util.Scanner;

public class j2_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        while (true) {
            int yobi = Integer.parseInt(sc.nextLine());
            if(yobi >= size) {
                break;
            }
            size += yobi;
        }
        System.out.println(size);
    }
}
