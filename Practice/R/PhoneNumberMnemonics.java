package Practice.R;
import java.util.*;

public class PhoneNumberMnemonics {
    public static void main(String[] args) {
        for(String s : findNumberMnemonics("1905")) {
            System.out.println(s);
        }
    }

    static ArrayList<String> findNumberMnemonics(String num) {
        Map<Character, char[]> choice = new HashMap<>();
        choice.put('2', new char[]{'a','b','c'});
        choice.put('3', new char[]{'d','e','f'});
        choice.put('4', new char[]{'g','h','i'});
        choice.put('5', new char[]{'j','k','l'});
        choice.put('6', new char[]{'m','n','o'});
        choice.put('7', new char[]{'p','q','r','s'});
        choice.put('8', new char[]{'t','u','v'});
        choice.put('9', new char[]{'w','x','y','z'});

        ArrayList<String> permutations = new ArrayList<>();
        recurse(permutations, choice, num, 0, "");
        return permutations;
    }

    static void recurse(ArrayList<String> permutations, Map<Character, char[]> letters, String num, int index, String build) {
        if(index == num.length()) {
            permutations.add(build);
            return;
        }
        char curr = num.charAt(index);
        if(curr == '1' || curr == '0') {
            recurse(permutations, letters, num, index+1, build + curr);
            return;
        }
        for(char c : letters.get(curr)) {
            recurse(permutations, letters, num, index+1, build + c);
        }
    }
}
