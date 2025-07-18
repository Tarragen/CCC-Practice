package Practice;
import java.util.*;
public class classPhotos {
    public static void main(String[] args) {
        System.out.println(findClassPhoto((ArrayList<Integer>) List.of(1,2,5),(ArrayList<Integer>) List.of(4,2,7)));
    }

    static boolean findClassPhoto(ArrayList<Integer> red, ArrayList<Integer> blue) {
        Collections.sort(red); Collections.sort(blue);

        boolean blueTaller = blue.get(0) > red.get(0), redTaller = red.get(0) > blue.get(0);
        if(!blueTaller && !redTaller) return false;
        for(int i = 0; i < red.size(); i++) {
            int r = red.get(i), b = blue.get(i);
            if((blueTaller && r>b) || (redTaller && b>r)) {
                return false;
            }

        }
        return true;
    }
}
