import java.util.*;
public class j4_23_trianglane_s1 {
    public static void main(String[] args) {
        int total = 0;
        String sentinel = "1";
        Scanner sc = new Scanner(System.in);
        int inputSize = Integer.parseInt(sc.nextLine());
        String[] a;
        String[] b;
        a = sc.nextLine().split(" ");
        b = sc.nextLine().split(" ");

        for(int i = 0; i < inputSize; i++) {
            String triA = a[i], triB = b[i];
            boolean spilledA = triA.equals(sentinel), spilledB = triB.equals(sentinel);
            if(spilledA) {
                total+=3;
            }
            if(spilledB) {
                total+=3;
            }
            if(spilledA && spilledB && i%2==0) {
                total-=2;
            }
            if(i+1<inputSize) {//next isn't null
                if(spilledA && a[i+1].equals(sentinel)) {
                    total-=2;
                }
                if(spilledB && b[i+1].equals(sentinel)) {
                    total-=2;
                }
            }
        }
        System.out.println(total);
    }
}
