import java.util.*;
public class j3_19_coldCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = Integer.parseInt(sc.nextLine());
        List<String> res = new ArrayList<>();

        for(int i = 0; i < inputNum; i++) {
            char[] line = sc.nextLine().toCharArray();
            StringBuilder currMsg = new StringBuilder();
            char curr = line[0];
            int count = 0;
            for (int j = 0; j < line.length; j++) {
                if(line[j] == curr) {
                    count++;
                } else {
                    currMsg.append(count).append(" ").append(curr).append(" ");
                    count = 1;
                    curr = line[j];
                }
            }
            currMsg.append(count).append(" ").append(curr);
            res.add(currMsg.toString());

        }
        for(String s : res) {
            System.out.println(s);
        }
    }
}
