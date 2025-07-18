import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s3_16_phenomenalReviews {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<Integer, List<Integer>> roads = new HashMap<>();
    static int[] pho;
    static Set<Integer> isPho = new HashSet<>();

    static boolean[] locked;
    static int phoCount;

    public static void main(String[] args) throws IOException {
        int min = Integer.MAX_VALUE;
        int n = readInt(); phoCount = readInt();
        pho = new int[phoCount];
        locked = new boolean[n+1];

        for(int i = 0; i < phoCount; i++) {
            int a = readInt();
            pho[i] = a;
            isPho.add(a);
        }

        int a, b;
        for(int i = 0; i < n-1; i++) {
            a = readInt(); b = readInt();
            roads.computeIfAbsent(a, k->new ArrayList<>()).add(b);
            roads.computeIfAbsent(b, k->new ArrayList<>()).add(a);
        }
        int steps = dfsSteps(pho[0]);
        for (int start : pho) {
            int rad = findRad(start);
            min = Math.min(min, steps * 2 - rad - 1);
        }
        System.out.println(min);
    }

    static int dfsSteps(int curr) {
        locked[curr] = true;
        int total = 0, links = 0;

        List<Integer> paths = roads.get(curr);
        for(int i : paths) {//for each path, if is a leaf node, it skips
            if(!locked[i]) {
                int branch = dfsSteps(i);
                if(branch != -1) { //has pho
                    total+=branch;
                    links++;
                    //System.out.println(curr);
                }
            }
        }

        locked[curr] = false;
        if(links== 0) {//leaf node, base case
            return isPho.contains(curr)? 1 : -1;
        }
        return total+1;
    }

    static int findRad(int curr) {
        locked[curr] = true;
        int max = Integer.MIN_VALUE, links = 0;

        List<Integer> paths = roads.get(curr);
        for(int i : paths) {
            if(!locked[i]) {
                int branch = findRad(i);
                if(branch != -1) { //has pho
                    max = Math.max(max, branch);
                    links++;
                    //System.out.println(curr);
                }
            }
        }
        locked[curr] = false;
        if(links== 0) {//leaf node, base case
            return isPho.contains(curr)? 1 : -1;
        }

        return max+1;
    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
