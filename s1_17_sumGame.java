import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s1_17_sumGame {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] swifts, semaphores;
        int games = readInt();
        swifts = new int[games]; semaphores = new int[games];

        int swiftTotal = 0, semaphoreTotal = 0;
        int k = 0;

        for(int i = 0; i < games; i++) {
            swifts[i] = readInt();
        }
        for(int i = 0; i < games; i++) {
            semaphores[i] = readInt();
        }
        for(int i = 0; i < games; i++) {
            swiftTotal += swifts[i];
            semaphoreTotal += semaphores[i];

            if(swiftTotal == semaphoreTotal) {
                k = i+1;
            }
        }

        System.out.println(k);
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
