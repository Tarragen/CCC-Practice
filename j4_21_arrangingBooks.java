import java.util.*;

public class j4_21_arrangingBooks {
    //! try killing self
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int singleSwap, doubleSwap;
        int numL = 0, numM = 0, numS = 0;
        int[] lSec = new int[3], mSec = new int[3], sSec = new int[3];
        String[] books = sc.nextLine().split("");
        sc.close();

        for (String curr : books) {
            if (curr.equals("L")) {
                numL++;
            } else if (curr.equals("M")) {
                numM++;
            } else {
                numS++;
            }
        }

        for(int i = 0; i < numL; i++) {
            String curr = books[i];
            if(curr.equals("L")) {
                lSec[0]++;
            } else if (curr.equals("M")) {
                lSec[1]++;
            } else {
                lSec[2]++;
            }
        }
        for(int i = numL; i < numL+numM; i++) {
            String curr = books[i];
            if(curr.equals("L")) {
                mSec[0]++;
            } else if(curr.equals("M")) {
                mSec[1]++;
            } else {
                mSec[2]++;
            }
        }
        for(int i = numL+numM; i < books.length; i++) {
            String curr = books[i];
            if(curr.equals("L")) {
                sSec[0]++;
            } else if(curr.equals("M")) {
                sSec[1]++;
            } else {
                sSec[2]++;
            }
        }

        singleSwap = Math.min(lSec[1], mSec[0]) + Math.min(lSec[2], sSec[0] + Math.min(mSec[2], sSec[1]));
        int swapped;
        swapped = Math.min(lSec[1], mSec[0]);
        lSec[1] -= swapped;
        mSec[0] -= swapped;
        lSec[0] += swapped;
        mSec[1] += swapped;
        swapped = Math.min(lSec[2], sSec[0]);
        lSec[2] -= swapped;
        sSec[0] -= swapped;
        lSec[0] += swapped;
        sSec[2] += swapped;
        swapped = Math.min(mSec[2], sSec[1]);
        mSec[2] -= swapped;
        sSec[1] -= swapped;
        mSec[1] += swapped;
        sSec[2] += swapped;

        doubleSwap = 2*(lSec[1] + lSec[2]);
        System.out.println(singleSwap + doubleSwap);
    }

}
