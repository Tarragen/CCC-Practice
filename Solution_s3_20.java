import java.io.*;
import java.util.*;

/**
 * CCC 2020 S3 - Searching for Strings
 * Problem: Find number of unique permutations of needle string that appear in haystack string
 * Solution approach: Rolling hash with frequency counting
 */
public class Solution_s3_20 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    // Hash arrays for double hashing technique
    static long[] primaryHash, secondaryHash;    // Store hash values for both hash functions
    static long[] basePowers1, basePowers2;      // Store powers of bases for both hash functions
    static final int MOD = (int) 1e9 + 7;       // Modulo to prevent integer overflow
    
    public static void main(String[] args) throws IOException {
        // Read input strings
        String needleStr = readLine();           // String to search for (and its permutations)
        String haystackStr = readLine();         // String to search in
        int needleLength = needleStr.length();
        int haystackLength = haystackStr.length();

        // Initialize hash arrays
        primaryHash = new long[haystackLength + 1];
        secondaryHash = new long[haystackLength + 1];
        basePowers1 = new long[haystackLength + 1];
        basePowers2 = new long[haystackLength + 1];

        // Initialize starting values
        primaryHash[0] = secondaryHash[0] = 0;
        basePowers1[0] = basePowers2[0] = 1;
        
        // Choose different prime bases for double hashing
        final int BASE1 = 131;
        final int BASE2 = 137;

        // Arrays to store character frequencies
        int[] needleFreq = new int[26];         // Frequency array for needle string
        int[] windowFreq = new int[26];         // Frequency array for current window

        // Count character frequencies in needle string
        for (int i = 0; i < needleLength; i++) {
            needleFreq[needleStr.charAt(i) - 'a']++;
        }

        // Compute rolling hash values for all prefixes of haystack
        for (int i = 1; i <= haystackLength; i++) {
            // Calculate primary hash
            primaryHash[i] = (primaryHash[i-1] * BASE1 + haystackStr.charAt(i-1)) % MOD;
            basePowers1[i] = basePowers1[i-1] * BASE1 % MOD;
            
            // Calculate secondary hash
            secondaryHash[i] = (secondaryHash[i-1] * BASE2 + haystackStr.charAt(i-1)) % MOD;
            basePowers2[i] = basePowers2[i-1] * BASE2 % MOD;
        }

        // Store unique permutations using their hash values
        Set<Long> uniquePermutations = new HashSet<>();

        // Slide window through haystack string
        for (int i = 1; i <= haystackLength; i++) {
            // Update frequency of current character
            windowFreq[haystackStr.charAt(i-1) - 'a']++;
            
            // Remove character that's no longer in window
            if (i > needleLength) {
                windowFreq[haystackStr.charAt(i-needleLength-1) - 'a']--;
            }

            // If frequencies match (potential permutation found)
            if (Arrays.equals(needleFreq, windowFreq)) {
                // Add hash of current substring to set
                uniquePermutations.add(getSubstringHash(i - needleLength - 1, i));
            }
        }

        // Output number of unique permutations found
        System.out.println(uniquePermutations.size());
    }

    /**
     * Computes combined hash value for substring from positions (l+1) to r
     * Uses double hashing to minimize collision probability
     */
    static long getSubstringHash(int left, int right) {
        // Calculate primary hash for substring
        long hash1 = (primaryHash[right] - primaryHash[left+1] * basePowers1[right-left-1] % MOD + MOD) % MOD;
        
        // Calculate secondary hash for substring
        long hash2 = (secondaryHash[right] - secondaryHash[left+1] * basePowers2[right-left-1] % MOD + MOD) % MOD;
        
        // Combine both hashes using bit operations
        return (hash1 << 31) | hash2;
    }

    // Input reading helper methods
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong() throws IOException { return Long.parseLong(next()); }
    static int readInt() throws IOException { return Integer.parseInt(next()); }
    static double readDouble() throws IOException { return Double.parseDouble(next()); }
    static char readCharacter() throws IOException { return next().charAt(0); }
    static String readLine() throws IOException { return br.readLine().trim(); }
}