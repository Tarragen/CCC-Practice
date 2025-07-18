import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] pens, changes;
    static List<int[]> maxAttributes;
    static List<List<Integer>> penAttributes;
    static int n, m, q;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        List<Integer> ans = new ArrayList<>();
        n = readInt(); m = readInt(); q = readInt();
        pens = new int[n][2];
        changes = new int[q][3];
        for(int i = 0; i < n; i++) {
            pens[i][0] = readInt();
            pens[i][1] = readInt();
        }
        for(int i = 0; i < q; i++) {
            changes[i][0] = readInt();
            changes[i][1] = readInt();
            changes[i][2] = readInt();;
        }



        int least = findLeast();
        int max = findMax(least);


        int total = 0;
        for(int[] i : maxAttributes) {
            total+=i[0];
        }
        total-=least;
        total+=max;
        ans.add(total);

        for (int[] change : changes) {
            if (change[0] == 1) {
                pens[change[1] - 1][0] = change[2];
            } else {
                pens[change[1] - 1][1] = change[2];
            }
            least = findLeast();
            max = findMax(least);
            total = 0;
            for (int[] j : maxAttributes) {
                total += j[0];
            }
            total -= least;
            total += max;
            ans.add(total);
        }

        for(int an : ans) {
            System.out.println(an);
        }


    }

    static int findLeast() {
        maxAttributes= new ArrayList<>(m);
        penAttributes = new ArrayList<>(m);
        for(int i = 0; i < n; i++) {
            penAttributes.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            penAttributes.get(pens[i][0]-1).add(pens[i][1]);
        }
        for(int i = 0; i < m; i++) {//find max attributes
            int max = 0;
            for(int j : penAttributes.get(i)) {
                max = Math.max(max, j);
            }
            maxAttributes.add(new int[]{max, i});
        }
        used = new boolean[maxAttributes.size()];

        int least = Integer.MAX_VALUE;
        maxAttributes.sort((a, b) -> Integer.compare(a[0], b[0]));//ascending order I think
        for(int i = m-1; i >= 0; i--) {
            if(maxAttributes.get(i)[0] < least) {
                least = maxAttributes.get(i)[0];

            }
            used[maxAttributes.get(i)[1]] = true;
        }
        return least;

    }

    static int findMax(int least) {
        //!you are now only looking for the second largest
        for(List<Integer> a : penAttributes) {
            a.sort(Collections.reverseOrder());
        }
        int max = least;
        for(int i = 0; i < penAttributes.size(); i++) {
            List<Integer> a = penAttributes.get(i);
            if(!used[i]) {
                max = Math.max(a.get(0), max);
            } else if(a.size()>1) {
                max = Math.max(a.get(1), max);
            }
        }
        return max;
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
