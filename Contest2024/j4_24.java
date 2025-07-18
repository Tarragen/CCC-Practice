package Contest2024;
import java.util.Scanner;

public class j4_24 {
    public static void main(String[] args) {
        // ! never pressed the faulty key after silent key and vice versa
        char correspondingKey = '-', faultyKey = '-', silentKey = '-';
        boolean silentKeyPressed = false;
        boolean silentKeyFound = false, faultyKeyFound = false;
        Scanner sc = new Scanner(System.in);
        String normal = sc.nextLine() + "-";
        String bad = sc.nextLine() + "-";
        char[] n = normal.toCharArray();
        char[] b = bad.toCharArray();
        int nLen = normal.length();
        int bLen = bad.length();
        if(nLen > bLen) {
            silentKeyPressed = true;
        }
        int bIndex = 0;
        int nIndex = 0;

        if(!silentKeyPressed) {
            for(int i = 0; i < n.length; i++) {
                if(n[i] != b[i]) {
                    correspondingKey = n[i];
                    faultyKey = b[i];
                    break;
                }
            }
        } else {
            char savedKey = '-', savedCKey = '-';
            int savedIndex = 0;
            boolean savedKeyFound = false, first = true;
            while (bIndex < bLen) {
                char bCurr = b[bIndex];
                char nCurr = n[nIndex];

                if(first && bCurr != nCurr) {
                     savedKey = bCurr;
                     savedCKey = nCurr;
                     savedIndex = bIndex;
                     savedKeyFound = true;
                     first = false;
                }
                if(savedKeyFound) {
                    if(nCurr == savedKey) {
                        silentKey = n[savedIndex];
                        silentKeyFound = true;
                        bIndex = savedIndex;
                        savedKeyFound = false;
                    } else if (nCurr == bCurr) {
                        faultyKey = savedKey;
                        correspondingKey = savedCKey;
                        faultyKeyFound = true;
                        savedKeyFound = false;
                    }
                }
                nIndex++;
                bIndex++;

                if(silentKeyFound) {
                    for (; nIndex < nLen; nIndex++) {
                        nCurr = n[nIndex];
                        bCurr = b[bIndex];
                        if(nCurr != silentKey) {
                            if(nCurr != bCurr) {
                                faultyKey = bCurr;
                                correspondingKey = nCurr;
                                break;
                            }
                            bIndex++;
                        }
                    }
                    break;
                } else if(faultyKeyFound) {
                    for (; nIndex < nLen; nIndex++) {
                        nCurr = n[nIndex];
                        bCurr = b[bIndex];
                        if(nCurr != correspondingKey && nCurr != bCurr) {
                            silentKey = nCurr;
                            break;
                        }
                        bIndex++;
                    }
                    break;
                }
            }
        }
        //-------------------------------------------------------------------------------------------------
        System.out.println(correspondingKey + " " + faultyKey);
        System.out.println(silentKey);
    }
}
