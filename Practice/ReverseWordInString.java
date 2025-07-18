package Practice;
import java.util.*;

public class ReverseWordInString {
    public static void main(String[] args) {
        System.out.println(reverseWord("We need to take   that bridge!"));
    }

    static String reverseWord(String word) {
        if(word.isEmpty()) return word;
        StringBuilder res = new StringBuilder();
        int n = word.length()-1;

        int pt2 = n;
        boolean prevIsWS = word.charAt(n) == ' ';
        while(n >= 0) {
            char curr = word.charAt(n);
            if(curr == ' ') {
                if(!prevIsWS) {
                    res.append(word, n+1, pt2+1);
                    pt2 = n;
                }
                prevIsWS = true;
            } else {
                if(prevIsWS) {
                    res.append(word, n+1, pt2+1);
                    pt2 = n;
                }
                prevIsWS = false;
            }
            n--;
        }
        res.append(word, n+1, pt2+1);
        return res.toString();

    }
}
