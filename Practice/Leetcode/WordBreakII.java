package Practice.Leetcode;
import java.util.*;

public class WordBreakII {
    private static List<String> dict;
    private static Set<String> setDict;
    private static String word;
    private static Map<String, List<String>> memoize = new HashMap<>();
    private static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        for(String s : wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"))) {
            System.out.println(s);
        }

    }


    public static List<String> wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
        word = s;
        setDict = new HashSet<>(wordDict);
        //recurse("", 0, 1); //? or "" and 0, 0


        return res;
    }


    /*
    * catsand
    *
    * cat sand
    * cats and
    *
    * */

    //? two states of memoize, works and doesn't work
    /*
    public void recurse(String progress, int left, int right) {
        //!build memoize point up from last recursion
        if(right > word.length() ) {
            return "!";
        }
        String curr = word.substring(left, right);
        String rest = word.substring(left);

        if(setDict.contains(rest)) {
            progress += rest;
            res.add(progress);
            memoize.put(rest, rest); //dog, dog
            return rest;
        }
        if(setDict.contains(curr)) {
            if(memoize.get(rest) != null) {
//                if (memoize.get(rest).equals("!")) return; //case of no work
                String stored = memoize.get(rest);
                progress += " " + stored;
                res.add(progress);


                memoize.put
                return curr + stored;
            }
            recurse(progress + curr + " ", left + curr.length(), left + curr.length() + 1);
            //memoize.put(rest, s1);

        }
        recurse(progress, left, right+1);
        //memoize.put(rest, s2);

        //if(s1.equals("!")) return s2;
        return;
    }*/
    //Naive works



    public static void recurseNaive(String progress, int left, int right) {
        if(right > word.length() ) return;//exit if no word

        String curr = word.substring(left, right);
        String rest = word.substring(left);
        if(setDict.contains(rest)) {//base case
            progress += rest;
            res.add(progress);
            return;
        }

        //check
        if(setDict.contains(curr)) {//two cases
            recurseNaive(progress + curr + " ", left+curr.length(), left+curr.length()+1);
        }
        recurseNaive(progress, left, right+1);
    }


}
