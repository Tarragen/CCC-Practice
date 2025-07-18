package Practice;
import java.util.*;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(isBalanced(")()("));
    }

    static boolean isBalanced(String brackets) {
        if((brackets.isEmpty())) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < brackets.length()) {
            char curr = brackets.charAt(i);
            i++;
            if(curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else if (curr == ')' || curr == ']' || curr == '}') {
                if(stack.isEmpty()) return false;
                char past = stack.pop();
                switch (curr) {
                    case ')':
                        if (past != '(') return false;
                        continue;
                    case ']':
                        if (past != '[') return false;
                        continue;
                    case '}':
                        if (past != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
