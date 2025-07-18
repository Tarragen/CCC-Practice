package Practice.DP;
import java.util.*;

public class SunsetViews {
    public static void main(String[] args) {
        List<Integer> res = findSunsetViews( new int[]{3,5,4,4,3,1,3,2}, "WEST");
        for(int i : res) {
            System.out.print(i);
        }
    }

    static ArrayList<Integer> findSunsetViews(int[] buildings, String direction)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int len = buildings.length;
        if(len == 0) return res;
        boolean pos = direction.equals("EAST");

        if(pos) {
            for (int i = 0; i < len/ 2; i++) {
                int temp = buildings[i];
                buildings[i] = buildings[len - 1 - i];
                buildings[len - 1 - i] = temp;
            }
        }
        int tallest = buildings[0];

        res.add(pos ? len-1 : 0);
        for(int i = 1; i < len; i++) { //length 8
            if (buildings[i] > tallest) {
                if (pos) {
                    res.add(len-i-1);
                } else {
                    res.add(i);
                }

                tallest = buildings[i];
            }
        }
        if(pos) {
            Collections.reverse(res);
        }
        return res;
    }
}
