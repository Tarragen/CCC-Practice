package Contest2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s2
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<Character> chars = new ArrayList<>();
        List<Long> occurrence = new ArrayList<>();

        String full = readLine();
        int len = full.length();
        long wantedDigit = readLong()+1;//retards made it 0 indexed

        int counter = 0, counter2=0;
        while(counter<len) {
            char c = full.charAt(counter);
            StringBuilder sb = new StringBuilder();

            for(counter2 = counter+1; counter2<len; counter2++) {
                char curr = full.charAt(counter2);
                if(Character.isDigit(curr)) {
                    sb.append(curr);
                } else {
                    break;
                }
            }
            chars.add(c);
            occurrence.add(Long.parseLong(sb.toString()));
            counter=counter2;
        }
        long total=0;
        for(int i = 0; i < chars.size(); i++) {
            total+=occurrence.get(i);
        }
        long wanted = wantedDigit%total;
        if(wanted == 0) {
            System.out.println(chars.get(chars.size()-1));
            return;
        }

        for(int i = 0; i < chars.size(); i++) {
            long num = occurrence.get(i);
            wanted-=num;
            if(wanted <= 0) {
                System.out.println(chars.get(i));
                break;
            }
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
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
}
