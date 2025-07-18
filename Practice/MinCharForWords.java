package Practice;
import java.util.*;

public class MinCharForWords {
    public static void main(String[] args) {
        char[] a = findMinChar(new String[] {"this", "that"});
        for (char each : a) {
            System.out.println(each);
        }
        System.out.println();
    }

    static char[] findMinChar(String[] words) {
        if(words.length == 0) return new char[]{};
        List<int[]> frequencies = new ArrayList<>();

        for (String word : words) {
            int[] frq = new int[256]; //ascii
            for (char c : word.toCharArray()) {
                frq[c]++;
            }
            frequencies.add(frq);
        }
        int[] totalFrq = new int[256];

        for(int i = 0; i < words.length; i++) {
            int[] curr = frequencies.get(i);

            for(int j = 0; j < 256; j++) {
                if(curr[j] > totalFrq[j]) {
                    totalFrq[j] = curr[j];
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 256; i++) {
            for(int j = 0; j < totalFrq[i]; j++) {
                str.append((char)i);
            }
        }
        return str.toString().toCharArray();

    }
}
