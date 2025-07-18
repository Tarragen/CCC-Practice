package Practice;
import java.util.*;

public class ValidIP {
    public static void main(String[] args) {

    }

    static ArrayList<String> findIPs(String base) {
        ArrayList<String> res = new ArrayList<>();
        int n = base.length();
        if(base.length() < 4) return res;

        for (int i = 1; i < Math.min(4, n - 2); i++) {
            for (int j = i + 1; j < i + Math.min(4, n - i - 1); j++) {
                for (int k = j + 1; k < j + Math.min(4, n - j); k++) {
                    String part1 = base.substring(0, i);
                    String part2 = base.substring(i, j);
                    String part3 = base.substring(j, k);
                    String part4 = base.substring(k);

                    if (isValidPart(part1) && isValidPart(part2)
                            && isValidPart(part3)
                            && isValidPart(part4)) {
                        res.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValidPart(String part) {
        if (part.length() > 3 || part.isEmpty()) return false;
        if (part.length() > 1 && part.startsWith("0")) return false;
        int value = Integer.parseInt(part);

        return value >= 0 && value <= 255;
    }
}
