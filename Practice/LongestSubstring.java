package Practice;
import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(findLongestSubstring("clementisacap"));
    }

    static String findLongestSubstring(String input) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        int maxLen = 0; String max = "";
        int left = 0, right = 0;

        while (right < input.length()) {
            char curr = input.charAt(right);
            if(frequency.containsKey(curr) && frequency.get(curr) >= left) {
                left = frequency.get(curr) + 1;
            }
            int len = right-left+1;
            if(len > maxLen) {
                maxLen = len;
                max = input.substring(left, right+1);
            }
            frequency.put(curr, right);
            right++;
        }

        return max;
    }
}
