import java.util.*;
public class j3_24_mock_rgbWords {
    // ! too hard for j3
    public static void main(String[] args) {
        long words = 0;
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String word = sc.nextLine();

        int rCount = 0, bCount = 0;
        int rCount2 = 0;
        boolean gExists = false;
        for(int i = 0; i <= len; i++) {
            if(i == len) {
                words += (long) rCount *bCount;
                break;
            }
            char curr = word.charAt(i);
            switch(curr) {
                case 'R':
                    if(gExists) {
                        rCount2++;
                    } else {
                        rCount++;
                    }
                    break;
                case 'G':
                    if(gExists) {
                        words += (long) rCount *bCount;
                        rCount = rCount2;
                        rCount2 = 0;
                        bCount = 0;
                    } else {
                        gExists = true;
                    }
                    break;
                case 'B':
                    if(gExists) {
                        bCount++;
                    }
                    break;
            }
        }
        System.out.println(words);
    }
}
