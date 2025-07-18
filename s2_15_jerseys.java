import java.io.*;
import java.util.*;

public class s2_15_jerseys {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int requestsFulfilled = 0;
        int j = readInt();
        int a = readInt();

        String[] jerseys = new String[j];
        boolean[] taken = new boolean[j];
        for(int i = 0; i < j; i++) {
            jerseys[i] = readLine();
        }

        for(int i = 0; i < a; i++) {
            String size = next();
            int location = readInt()-1;
            if(taken[location]) {
                continue;
            }
            if(size.equals("S")) {
                requestsFulfilled++;
                taken[location] = true;
            } else if (size.equals("M") && (jerseys[location].equals("M") || jerseys[location].equals("L"))) {
                requestsFulfilled++;
                taken[location] = true;
            } else if (size.equals("L") && jerseys[location].equals("L")){
                requestsFulfilled++;
                taken[location] = true;
            }
        }
        System.out.println(requestsFulfilled);
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
