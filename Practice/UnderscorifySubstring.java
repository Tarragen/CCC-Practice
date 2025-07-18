package Practice;
import java.util.*;

public class UnderscorifySubstring {
    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest works";
        System.out.println(control(str, "test"));
    }

    static String control (String str, String substring) {
        return underscorify(str, getLocations(str, substring));
    }

    static String underscorify(String str, List<int[]> locations) {
        StringBuilder res = new StringBuilder(str);

        for (int i = locations.size() - 1; i >= 0; i--) {
            int[] location = locations.get(i);
            res.insert(location[1], "_");
            res.insert(location[0], "_");
        }
        return res.toString();
    }

    static List<int[]> getLocations(String str, String substring) {
        List<int[]> locations = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int location = str.indexOf(substring, i);
            if (location == -1) break;
            locations.add(new int[]{location, location + substring.length()});
            i = location + 1;
        }
        if (locations.isEmpty()) return locations;

        List<int[]> merged = new ArrayList<>();
        int[] curr = locations.get(0);

        for (int j = 1; j < locations.size(); j++) {
            int[] next = locations.get(j);
            if (curr[1] >= next[0]) {
                curr[1] = next[1];
            } else {
                merged.add(curr);
                curr = next;
            }
        }
        merged.add(curr);
        return merged;
    }




}
