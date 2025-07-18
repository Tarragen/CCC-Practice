package Practice.Leetcode;
import java.util.*;

public class StocksII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = prices.length-1; i > 0; i--) {
            if(prices[i] > prices[i-1]) {
                sum+=prices[i]-prices[i-1];
            }
        }
        return sum;
    }

//! memoization too slow with O(n^2), greedy O(n) works as able to buy and sell on the same day, so adding the
//! difference of stocks results in no loss
//? eg. 7, 8, 900 - (900-8) + (8-7) is the same as 900 - 7, so no need to explore every possible path
//    static int[] bestB1, bestB2, bestI1, bestI2;
//    static boolean[] bb1, bb2, bi1, bi2;
//    static int[] p;
//    static int n;

//    public static int maxProfit(int[] prices) {
//        p = prices;
//        n = prices.length-1;
//        bestB1 = new int[n]; bb1 = new boolean[n];
//        bestB2 = new int[n]; bb2 = new boolean[n];
//        bestI1 = new int[n]; bi1 = new boolean[n];
//        bestI2 = new int[n]; bi2 = new boolean[n];
//        return Math.max(recurse(0, false, true), recurse(0, false, false));
//    }
//
//    public static int recurse(int curr, boolean boughtBefore, boolean act) {
//        if(curr == n) { //last prices, more profitable to not buy
//            return boughtBefore ? p[curr] : 0;
//        }
//        boolean skip = false;
//        int res = 0, interact;
//        if(act) {
//            interact = boughtBefore ? p[curr] : -p[curr];
//            boughtBefore = !boughtBefore;
//            if(boughtBefore && bb1[curr]) {
//                skip = true;
//                res = bestB1[curr];
//            } else if (bb2[curr] && !boughtBefore) {
//                skip = true;
//                res = bestB2[curr];
//            }
//        } else {
//            if(boughtBefore && bi1[curr]) {
//                skip = true;
//                res = bestI1[curr];
//            } else if (bi2[curr] && !boughtBefore) {
//                skip = true;
//                res = bestI2[curr];
//            }
//            interact = 0;
//        }
//
//        if(!skip) {
//            int a = recurse(curr+1, boughtBefore, true);
//            int b = recurse(curr+1, boughtBefore, false);
//            res = interact + Math.max(a, b);
//        }
//
//        if(act) {//stocks array
//            if(boughtBefore) {
//                bestB1[curr] = Math.max(res, bestB1[curr]);
//            } else {
//                bestB2[curr] = Math.max(res, bestB2[curr]);
//            }
//        } else {
//            if(boughtBefore) {
//                bestI1[curr] = Math.max(res, bestI1[curr]);
//            } else {
//                bestI2[curr] = Math.max(res, bestI2[curr]);
//            }
//        }
//
//        return res;
//    }
}
