import java.util.*;
public class j4_19_flipper_s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = {{1,2}, {3,4}};
        char[] instructions = sc.nextLine().toCharArray();

        for(int i = 0; i < instructions.length; i++) {
            if(i+1 < instructions.length && instructions[i] == instructions[i+1]) {
                i++;
                continue;
            }
            if(instructions[i] == 'H') {
                int[] temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            } else {
                int temp = nums[0][0];
                nums[0][0] = nums[0][1];
                nums[0][1] = temp;

                temp = nums[1][0];
                nums[1][0] = nums[1][1];
                nums[1][1] = temp;
            }
        }

        for(int[] i : nums) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
