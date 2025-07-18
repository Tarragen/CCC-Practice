package Practice;
import java.util.*;

public class longestPeak {
    public static void main(String[] args) {
        System.out.println(findLongest(new int[]{1,2,3,3,3,0,10,6,5,-1,-3,2,3}));
    }

    public static int findLongest(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        int longest = 0;
        Map<Integer,Integer> peaks = new HashMap<>();

        for(int i = 1; i < arr.length-1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                peaks.put(i, arr[i]);
            }
        }

        for(Map.Entry<Integer, Integer> entry : peaks.entrySet()) {
            int index = entry.getKey();
            int val = entry.getValue();

            int i = index-1, count = 0, curr = val;
            while (i>=0 && arr[i] < curr) {
                count++;
                curr = arr[i];
                i--;
            }
            i = index+1;
            curr = val;
            while(i<arr.length && arr[i] < curr) {
                count++;
                curr = arr[i];
                i++;
            }
            longest = Math.max(longest, count+1);
        }
        return longest;
    }
}

