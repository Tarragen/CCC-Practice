package Practice;
import java.util.*;

public class SquareOfZeroes {
    /*
    * Use corners instead, find corners, insert into 4 arrays of left up, left down, right up, right down,
    * Then run through lines
    * */

    public static void main(String[] args) {
        System.out.println(containsSquare(new int[][] {
                {0, 1, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1}}));
    }

    static boolean containsSquare(int[][] mat) {
        int sizeRestrict = Math.max(mat.length, mat[0].length);

        for(int i = sizeRestrict; i>= 2; i--) {
            for (int j = 0; j <= mat.length-i; j++) { //row
                for(int k = 0; k <= mat[0].length-i; k++) { //col
                    //do thing
                    boolean is = true, skip = false;
                    for(int x = 0; x < i; x++) {
                        if((mat[j][k+x] != 0)||(mat[j+i-1][k+x] != 0)) {
                            is = false;
                            skip = true;
                            break;
                        }

                    }
                    if(!skip) {
                        for(int x = 1; x < i-1; x++) {
                            if((mat[j+x][k] !=0) || (mat[j+x][k+i-1] != 0)){
                                is = false;
                                break;
                            }
                        }
                    }
                    if(is) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    static boolean containsSquare(List<List<Integer>> mat) {
        int sizeRestrict = Math.max(mat.size(), mat.get(0).size());

        for(int i = sizeRestrict; i>= 2; i--) {
            for (int j = 0; j <= mat.size()-i; j++) { //row
                for(int k = 0; k <= mat.get(0).size()-i; k++) { //col
                    //do thing
                    boolean is = true, skip = false;
                    for(int x = 0; x < i; x++) {
                        if((mat.get(j).get(k+x) != 0)||(mat.get(j+i-1).get(k+x) != 0)) {
                            is = false;
                            skip = true;
                            break;
                        }

                    }
                    if(!skip) {
                        for(int x = 1; x < i-1; x++) {
                            if((mat.get(j+x).get(k) !=0) || (mat.get(j+x).get(k+i-1) != 0)){
                                is = false;
                                break;
                            }
                        }
                    }
                    if(is) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
