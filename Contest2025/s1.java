package Contest2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int a = readInt(), b = readInt(), x = readInt(), y = readInt();
        int case1 = (a+x)*2 + Math.max(b,y)*2;
        int case2 = (b+y)*2 + Math.max(a,x)*2;
        System.out.println(Math.min(case1, case2));

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
