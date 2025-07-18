import java.util.*;
public class j4_22_goodGroups {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> sameGroup = new ArrayList<>();
        List<List<String>> diffGroup = new ArrayList<>();
        int violations = 0;

        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            String p1 = sc.next();
            String p2 = sc.next();
            List<String> pair = new ArrayList<>();
            pair.add(p1);
            pair.add(p2);
            sameGroup.add(pair);//adds a pair
        }

        int y = sc.nextInt();
        for (int i = 0; i < y; i++) {
            String p1 = sc.next();
            String p2 = sc.next();
            List<String> pair = new ArrayList<>();
            pair.add(p1);
            pair.add(p2);
            diffGroup.add(pair);//adds a pair
        }

        int g = sc.nextInt();
        for (int row = 1; row <= g; row++) {
            String p1 = sc.next();
            String p2 = sc.next();
            String p3 = sc.next();
            map.put(p1, row);//adds each element with the row
            map.put(p2, row);
            map.put(p3, row);
        }

        for (List<String> same : sameGroup) {//violation if not on same row
            int p1 = map.get(same.get(0));
            int p2 = map.get(same.get(1));
            if (p1 != p2) {
                violations++;
            }
        }

        for (List<String> diff : diffGroup) {//violation if on same row
            int p1 = map.get(diff.get(0));
            int p2 = map.get(diff.get(1));
            if (p1 == p2) {
                violations++;
            }
        }

        System.out.println(violations);
    }
}
