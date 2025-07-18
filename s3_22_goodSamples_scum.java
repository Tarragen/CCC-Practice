import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s3_22_goodSamples_scum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        long k = readLong();

        //TODO scum first two subtasks

        if(k < n || k > (n*2-1)) {
            System.out.println(-1);
            return;
        }

        long remaining = k-n;


        if(n%2==1) {
            long remain2 = (remaining-1)/2;
            long remain1 = remaining - (remain2*2);

            System.out.print((remain1>0)?"2 ":"1 ");

            for(int i = 0; i < (n/2)-1; i++) {
                System.out.print("1 ");
                if(remain2 > 0) {
                    System.out.print("2 ");
                    remain2--;
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.print("1 ");
            System.out.println(remain1>1?"2":"1");

        } else {
            long remain2 = remaining/2;
            long remain1 = remaining%2;
            for(int i = 0; i < (n/2)-1; i++) {
                System.out.print("1 ");
                if(remain2 > 0) {
                    System.out.print("2 ");
                    remain2--;
                } else {
                    System.out.print("1 ");
                }

            }
            System.out.print("1 ");
            System.out.println(remain1>0?"2":"1");

        }



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

}
