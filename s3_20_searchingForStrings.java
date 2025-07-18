import java.util.*;
import java.io.*;

public class s3_20_searchingForStrings {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count = 0;
    static char[] letters;
    static boolean[] used;
    static Set<String> combos;
    static int nLen;

    public static void main(String[] args) throws IOException {
        String n = readLine();
        String h = readLine();
        nLen = n.length();

        if(nLen > h.length()) {
            System.out.println(0);
            return;
        }

        letters = n.toCharArray();
        used = new boolean[nLen];
        combos = new HashSet<>();

        findCombos("");

        for(String s : combos) {
            if(h.contains(s)) {
                count++;
            }
        }
        System.out.println(count);

    }

    static void findCombos(String curr) {
        if(curr.length() == nLen) {
            combos.add(curr);
            return;
        }
        for(int i = 0; i < nLen; i++) {
            if(!used[i]) {
                used[i] = true;
                findCombos(curr + letters[i]);
                used[i] = false;
            }
        }

    }


    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
