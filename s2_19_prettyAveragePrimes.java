import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s2_19_prettyAveragePrimes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] nums;
        boolean[] checkPrime;
        Set<Integer> primes = new HashSet<>();
        List<Integer> primesArr = new ArrayList<>();

        int pNum = readInt(), max = Integer.MIN_VALUE;
        nums = new int[pNum];

        for(int i = 0; i < pNum; i++) {
            int curr = readInt();
            nums[i] = curr;
            max = Math.max(max, curr);
        }
        checkPrime = new boolean[max*2+1];
        checkPrime[0] = true;
        checkPrime[1] = true;
        for(int i = 2; i < checkPrime.length; i++) {
            if(checkPrime[i]) {
                continue;
            }
            for(int j = 2; j*i < checkPrime.length; j++) {
                checkPrime[j*i] = true;
            }
        }
        for(int i = 0; i < checkPrime.length; i++) {
            if(!checkPrime[i]) {
                primes.add(i);
                primesArr.add(i);
            }
        }

        for (int num : nums) {
            int curr = num * 2;
            for (int j : primesArr) {
                if (primes.contains(curr - j)) {
                    System.out.println(j + " " + (curr - j));
                    break;
                }
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
}
