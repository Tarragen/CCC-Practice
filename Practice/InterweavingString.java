package Practice;
import java.util.*;

public class InterweavingString {
    public static void main(String[] args) {
        System.out.println(interweavable("aabcc","dbbca","aadbbcbcac"));
    }

    static boolean interweavable(String s1, String s2, String s3) {
        return recurse(0,0,s1,s2,s3);
    }
    static boolean recurse(int p1, int p2, String s1, String s2, String s3) {
        boolean firstWorks = false, secondWorks = false;
        int p3 = p1+p2;
        if(p3 == s3.length()) {
            return true;
        } else if(p1 >= s1.length()) {
            return s3.substring(p3).equals(s2.substring(p2));
        } else if (p2 >= s2.length()) {
            return s3.substring(p3).equals(s1.substring(p1));
        }
        char curr = s3.charAt(p3);
        char c1 = s1.charAt(p1);
        char c2 = s2.charAt(p2);

        if(!(curr == c1) && !(curr == c2)) {
            return false;
        }
         if (curr == c1) {
            firstWorks = recurse(p1 + 1, p2, s1, s2, s3);
        }
        if (curr == c2) {
            secondWorks = recurse(p1, p2+1, s1, s2, s3);
        }

        return firstWorks || secondWorks;
    }
}
