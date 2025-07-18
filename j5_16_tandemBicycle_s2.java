import java.util.*;
public class j5_16_tandemBicycle_s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int problemType = Integer.parseInt(sc.nextLine());
        final int participants = Integer.parseInt(sc.nextLine());
        String[] dInput = sc.nextLine().split(" ");
        String[] pInput = sc.nextLine().split(" ");

        ArrayList<Integer> d = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();

        for(int i = 0; i < participants; i++) {
            d.add(Integer.parseInt(dInput[i]));
            p.add(Integer.parseInt(pInput[i]));
        }
        Collections.sort(d);
        if(problemType == 1) {
            Collections.sort(p);
        } else {
            p.sort(Collections.reverseOrder());
        }
        int total = 0;
        for(int i = 0; i < participants; i++) {
            total += Math.max(d.get(i), p.get(i));
        }

        System.out.println(total);
    }
}
