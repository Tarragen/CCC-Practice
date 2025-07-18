package Contest2024;

import java.util.Scanner;

public class j1_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = Integer.parseInt(sc.nextLine());
        int g = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        System.out.println((r*3) + (g*4) + (b*5));
    }
}
