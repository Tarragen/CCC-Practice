import java.util.*;
public class s2_24_heavyLightComposition {
    //frequency array?
    //! try O(n + 26)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int t = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        for (int i = 0; i < t; i++) {
            boolean isAlternating = true;
            String l = sc.nextLine();
            char[] letters = l.toCharArray();
            int[] total = new int[26];

            for (int j = 0; j < n; j++) {
                total[letters[j] - 97]++;
            }
            boolean heavyIsFirst = total[letters[0] - 97] != 1;
            for (int j = 0; j < letters.length; j++) {
                char c = letters[j];
                boolean currIsHeavy = total[c-97] > 1;

                if(j%2 == 1) {
                    if (heavyIsFirst) {
                        if(currIsHeavy) {
                            isAlternating = false;
                            break;
                        }
                    } else {
                        if(!currIsHeavy) {
                            isAlternating = false;
                            break;
                        }
                    }
                } else {
                    if (heavyIsFirst) {
                        if(!currIsHeavy) {
                            isAlternating = false;
                            break;
                        }
                    } else {
                        if(currIsHeavy) {
                            isAlternating = false;
                            break;
                        }
                    }
                }
            }
            if(isAlternating) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }
}
