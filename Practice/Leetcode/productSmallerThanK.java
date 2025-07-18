package Practice.Leetcode;
import java.util.*;

public class productSmallerThanK {
    static int ans;

    public static int ltk(int[] nums, int k) {
//        int ways = 0;
//        if(nums.length == 0 || nums.length == 1) {
//            return nums.length;
//        }
//        int left = 0, right = 1, prod = nums[0];
//        if(prod < k) {ways++;}
//
//        while (right < nums.length) {
//            int curr = nums[right];
//            right++;
//        }
//        return ways;
        return -1;
    }

    static void recurse(boolean[] lUsed, boolean[]rUsed, int[] nums, List<String> steps, int depth) {

        for(int i = 0; i < nums.length; i++) { //each num
            //check all variations of left
            if(!lUsed[i]) {
                lUsed[i] = true;
                for(int j = i-1; j >= 0; j--) {
                    //add step
                    //adjust array
                }
                lUsed[i] = false;
            }

            if(!rUsed[i]) {
                rUsed[i] = true;
                for(int j = i + 1; j < nums.length; j++) {

                }
                rUsed[i] = false;
            }

            //check all variations of right
        }
    }

    public static void main(String[] args) {
        System.out.println(ltk(new int[] {10,5,2,6}, 100));
    }
}
