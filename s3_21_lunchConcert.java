import java.util.*;
import java.io.*;

public class s3_21_lunchConcert {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> friends;
    /*
    * Due to the distribution of students, graph will always look like a concave-up parabola, a U shape.
    *
    * It will never resemble a W shape, as the students' walking speed and distance away can only act as
    * weights, shifting the center.
    *
    * Use binary search in this scenario
    * */

    public static void main(String[] args) throws IOException {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = readInt();

        friends = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int pos = readInt(), walkTime = readInt(), hearRange = readInt();
            min = Math.min(min, pos);
            max = Math.max(max, pos);
            friends.add(new int[] {pos, walkTime, hearRange});
        }
        int left = min, right = max, mid;
        while(left <= right) {
            mid = (right-left)/2 + left;
            long curr = findTime(mid);
            long l = findTime(mid-1);
            long r = findTime(mid+1);

            if(l > curr && r > curr) {
                System.out.println(curr);
                return;
            } else if (l == curr && curr == r) {
                System.out.println(curr);
                return;
            }

            if(l > curr) {
                left = mid;
            } else if (r > curr) {
                right = mid;
            }
        }

    }

    static long findTime(int pos) {
        long time = 0;
        for(int[] friend : friends) {
            time += (long) Math.max(Math.abs(pos - friend[0]) - friend[2], 0) *friend[1];
        }
        return time;
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
