import java.util.*;
public class j3_22_harpTuning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(Character.isLetter(curr)) {
                sb.append(curr);
            } else if (!Character.isLetterOrDigit(curr)) {
                sb.append(' ');
                if(curr == '+') {
                    sb.append("tighten");
                } else {
                    sb.append("loosen");
                }
                sb.append(' ');
            } else if (Character.isDigit(curr)) {
                sb.append(curr);
                if(i+1 == input.length() || !Character.isDigit(input.charAt(i+1))) {
                    System.out.println(sb.toString());
                    sb.setLength(0);
                }
            }
        }
    }
}
