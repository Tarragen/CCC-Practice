import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s1_15_zeroThatOut {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<Integer> bs = new ArrayList<>();

        int inputs = readInt();
        int curr;

        for(int i = 0; i < inputs; i++) {
            curr = readInt();
            if(curr != 0) {
                bs.add(curr);
            } else {
                bs.removeLast();
            }
        }
        int total = 0;
        for(int i : bs) {
            total+=i;
        }
        System.out.println(total);
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
