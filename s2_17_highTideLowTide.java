import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s2_17_highTideLowTide {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<Integer> lowTide = new ArrayList<>();
        List<Integer> highTide = new ArrayList<>();
        boolean oddTides;
        int median;

        int measurements = readInt();
        int[] tides = new int[measurements];

        for(int i = 0; i < measurements; i++) {
            tides[i] = readInt();
        }
        oddTides = tides.length%2 == 1;

        Arrays.sort(tides);
        if(oddTides) {
            median = tides[tides.length/2];
        } else {
            median = tides[tides.length/2 - 1];
        }
        for (int i : tides) {
            if (i <= median) {
                lowTide.add(i);//backwards
            } else {
                highTide.add(i);
            }
        }
        for (int i = 0; i < tides.length/2; i++) {
            System.out.print(lowTide.get((tides.length/2)-i-(oddTides ? 0 : 1)));
            System.out.print(" ");
            System.out.print(highTide.get(i));
            System.out.print(" ");
        }
        if(oddTides) {
            System.out.print(lowTide.get(0));
        }


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
