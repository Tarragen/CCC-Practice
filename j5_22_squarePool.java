import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class j5_22_squarePool {
    //TODO [utilize a hashmap to store tree place, then brute force] too slow
    //! Does not work - Next Step: skip x amount by tree location

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, List<Integer>> trees = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int best = 0;
        int n = readInt(), tree = readInt();
        for(int i = 0; i < tree; i++) {
            int r = readInt(), c = readInt();
            trees.computeIfAbsent(c, k-> new ArrayList<>()).add(r);
        }
        for(int i = 1; i <= n; i++) { //each square size
            boolean works = true;
            outerloop:
            for(int a = 1; a <= n-i+1; a++) {//each row
                for(int b = 1; b <= n-i+1; b++) {//each col
                    works = true;
                    for(int j = 0; j < i; j++) {//each vertical slice
                        List<Integer> treesInSlice = trees.get(b+j);
                        if(treesInSlice == null) {
                            continue;
                        }
                        boolean blocked = false;
                        for(int t : treesInSlice) {
                            if (inRange(t, a, a+i-1)) {//blocked by tree
                                blocked = true;
                                works = false;
                                break;
                            }
                        }
                        if(blocked) {
                            b+=j;//!doesn't work
                            break;
                        }
                    }
                    if(works) {
                        best = i;
                        break outerloop;
                    }
                }
            }
            if(!works) {//nothing bigger will work
                System.out.println(best);
                return;
            }

        }
        System.out.println(best);

    }

//    public static void main(String[] args) throws IOException {
//        int best = 0;
//        int n = readInt(), tree = readInt();
//        for(int i = 0; i < tree; i++) {
//            int r = readInt(), c = readInt();
//            trees.computeIfAbsent(c, k-> new ArrayList<>()).add(r);
//        }
//        for(int i = n; i >=1; i--) { //each square size
//            boolean works = true;
//            outerloop:
//            for(int a = 1; a <= n-i+1; a++) {//each row
//                for(int b = 1; b <= n-i+1; b++) {//each col
//                    works = true;
//                    for(int j = 0; j < i; j++) {//each vertical slice
//                        List<Integer> treesInSlice = trees.get(b+j);
//                        if(treesInSlice == null) {
//                            continue;
//                        }
//                        boolean blocked = false;
//                        for(int t : treesInSlice) {
//                            if (inRange(t, a, a+i-1)) {//blocked by tree
//                                blocked = true;
//                                works = false;
//                                break;
//                            }
//                        }
//                        if(blocked) {
//                            b+=j;
//                            break;
//                        }
//                    }
//                    if(works) {
//                        best = i;
//                        break outerloop;
//                    }
//                }
//            }
//            if(works) {
//                System.out.println(best);
//                return;
//            }
//
//        }
//        System.out.println(0);
//
//    }

    static boolean inRange(int n, int l, int h) {
        return n>=l&&n<=h;
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
