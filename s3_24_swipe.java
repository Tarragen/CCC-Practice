import java.util.*;
import java.io.*;

public class s3_24_swipe {
    //! transform a into b, not vice versa
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
//        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
//        int moves = 0;
        int n = readInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = readInt();
//            s1.append(a[i]);
        }
        for(int i = 0; i < n; i++) {
            b[i] = readInt();
//            s1.append(b[i]);
        }
        //!erroneous
//        if (n == 2) {
//            //! subtask 1
//            if(b[0] == b[1] && (a[0] == b[0] || a[1] == b[0])) {
//                System.out.println("YES");
//                System.out.println("1");
//                if(a[0] == b[0]) {
//                    System.out.println("R 0 1");
//                } else {
//                    System.out.println("L 0 1");
//                }
//            } else {
//                System.out.println("NO");
//            }
//            return;
//        }
        List<Integer> comp1 = compress(a, n);
        List<Integer> comp2 = compress(b, n);

        int lowLimiter = 0;
        for(int i = 0; i < comp2.size(); i++) {//each element in bottom arr
            int curr = comp2.get(i);
            boolean has = false;
            for(int j = lowLimiter; j < comp1.size(); j++) {//all elements next
                if(curr == comp1.get(j)) {
                    lowLimiter = j;
                    has = true;
                    break;
                }
            }
            if(!has) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    static List<Integer> compress(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int curr = arr[i];
            temp.add(curr);
            int j = 1;
            while((i+j)<arr.length && arr[i+j]==curr) {
                j++;
            }
            i+=j-1;
        }
        return temp;
    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
