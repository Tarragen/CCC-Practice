import java.util.*;
import java.io.*;

public class s3_14_genevaConfection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        List<String> ans = new ArrayList<>();
        int repeat = readInt();

        for(int z = 0; z < repeat; z++) {
            int startPoint = 0;
            int n = readInt();
            int[] nums = new int[n];
            for(int i = n-1; i >= 0; i--) { //initializing
                nums[i] = readInt();
                if (nums[i] == 1) {
                    startPoint = i;
                }
            }

            Stack<Integer> order = new Stack<>();

            for(int i = 0; i < startPoint; i++) { //put everything before 1 into stack
                order.push(nums[i]);
            }
            int counter = 2;
            for(int i = startPoint+1; i < n; i++) {
                if(!order.isEmpty() && order.peek() == counter) {
                    i--; //ensure same number next time
                    order.pop();
                    counter++;
                    continue;
                }
                if(nums[i]!=counter) {
                    order.push(nums[i]);
                } else {
                    counter++;
                }
            }
            boolean real = true;
            for(int i = counter; i <= n; i++) {
                if(order.pop()!=i) {
                    real = false;
                    ans.add("N");
                    break;
                }
            }
            if(real) {
                ans.add("Y");
            }
        }
        for(String s : ans) {
            System.out.println(s);
        }
    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
