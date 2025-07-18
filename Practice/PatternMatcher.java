package Practice;
import java.util.*;

public class PatternMatcher {
    public static void main(String[] args) {
        String[] ans = patternMatcher("yyy", "awoogaawoogaawooga");
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    static String[] patternMatcher(String pattern, String string) {
        int len = string.length();
        if(pattern.isEmpty() || len == 0 ||pattern.length() > len) {
            return new String[]{};
        }
        boolean xFirst = pattern.charAt(0) == 'x';
        int x = 0, y = 0;

        for(int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'x') {
                x++;
            } else {
                y++;
            }
        }

        if(y == 0 || x == 0) {
            double check = len/pattern.length();
            if(check%1 !=0) {
                return new String[]{};
            }
            String res = string.substring(0, (len/pattern.length()));
            return x==0 ? new String[]{"", res} : new String[]{res, ""};
        }

        for(int xLen = 1; xLen <= (len - y)/x; xLen++) {
            String xStr = null, yStr = null;
            double yRLen = (double)(len - x*xLen) / y;
            if(yRLen%1!=0) { //if not full num
                continue;
            }
            int yLen = (int) yRLen;
            if(xFirst) {
                xStr = string.substring(0, xLen);
                for(int i = 1; i < pattern.length(); i++) {
                    if (pattern.charAt(i) != 'x') {
                        yStr = string.substring(i*xLen,((i*xLen) + yLen));
                        break;
                    }
                }
            } else {
                yStr = string.substring(0, (int)yLen);
                for(int i = 1; i < pattern.length(); i++) {
                    if (pattern.charAt(i) != 'y') {
                        xStr = string.substring(i*yLen, ((i*yLen) + xLen));
                        break;
                    }
                }
            }
            StringBuilder test = new StringBuilder();
            for(char curr : pattern.toCharArray()) {
                if(curr == 'x') {
                    test.append(xStr);
                } else {
                    test.append(yStr);
                }
            }
            if(test.toString().equals(string)) {
                return new String[] {xStr, yStr};
            }

        }
        return new String[]{};
    }
}
