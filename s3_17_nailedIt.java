import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
TODO 9/15 points, 12/15 points for c++
! This would pass quartile mark and score in honour roll group 5 (37-39)
*/
public class s3_17_nailedIt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

//    public static void main(String[] args) throws IOException {
//        int max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        int longest = 0, ways = 0;
//        int[] all, frq;
//        int inputs = readInt();
//        all = new int[inputs];
//
//        for(int i = 0; i < inputs; i++) {
//            int curr = readInt();
//            all[i] = curr;
//            if(curr > max) {
//                secMax = max;
//                max = curr;
//            } else if (curr > secMax) {
//                secMax = curr;
//            }
//            if(curr < min) {
//                min = curr;
//            }
//        }
//        frq = new int[max];
//        for(int i = 0; i < inputs; i++) {
//            frq[all[i]-1]++;
//        }
//        int largestPlank = max + secMax;
//
//
//        for(; largestPlank > min; largestPlank--) {
//            int[] frqDupe = frq.clone();
//            int currMax = 0;
//            for(int i : all) { //subtract the number, if correspondent exists, add and subtract from frqDupe
//                int wanted = largestPlank-i;
//                if(wanted <= frqDupe.length && wanted > 0) {
//                    if(wanted == i && !(frqDupe[wanted-1] > 1)) {
//                        continue;
//                    }
//                    if (frqDupe[i - 1] > 0 && frqDupe[wanted - 1] > 0) {//if both are valid
//                        frqDupe[wanted - 1]--;
//                        frqDupe[i - 1]--;
//                        currMax++;
//                    }
//                }
//            }
//            if(currMax > longest) {
//                longest = currMax;
//                ways = 1;
//            } else if (currMax == longest) {
//                ways++;
//            }
//        }
//        System.out.println(longest + " " + ways);
//    }

    public static void main(String[] args) throws IOException {
        int[] frq = new int[2001], dp = new int[4001];
        int inputs = readInt();

        for(int i = 1; i <= inputs; i++) {
            int curr = readInt();
            frq[curr]++;
        }

        for(int i = 1; i < 2001; i++) {
            for(int j = i; j < 2001; j++) {
                if(j == i) {
                    dp[i+j] += frq[i]/2;
                } else {
                    dp[i+j] += Math.min(frq[i], frq[j]);
                }
            }
        }
        int max = 0, count = 0;
        for(int i = 1; i < dp.length; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        for(int i = 1; i < dp.length; i++) {
            if(dp[i] == max) count++;
        }

        System.out.println(max+" "+count);


    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
