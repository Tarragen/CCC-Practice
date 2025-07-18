package Practice.DP;
import java.util.*;

public class Knapsack {
    static class Node {
        public int weight;
        public int value;
        public List<Integer> path;

        public Node(int w, int v, int index) {
            this.path = new ArrayList<>();
            path.add(index);
            this.weight = w;
            this.value = v;
        }

        public Node(int w, int v, List<Integer> path) {
            this.path = new ArrayList<>(path);
            this.weight = w;
            this.value = v;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = findMax(new int[][]{{465,100},{400,85},{255,55},{350,45},{650,130},
                {1000,190},{455,100},{100,25},{1200,190},{320,65},{750,100},{50,45},{550,65},{100,50},
                {600,70},{255,40}}, 200);

        for(List<Integer> a : res) {
            for(int i : a) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> findMax(int[][] items, int capacity) {
        List<Node> combo = new ArrayList<>();
        combo.add(new Node(items[0][1], items[0][0], 0));
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i < items.length; i++) {// this section should be fine
            int currW = items[i][1];
            int currV = items[i][0];
            combo.add(new Node(currW, currV, i));
            int length = combo.size();
            for(int j = 0; j < length-1; j++) {
                Node curr = combo.get(j);
                int tVal = curr.value+currV;
                int tWei = curr.weight+currW;

                if(tWei > capacity) continue;

                List<Integer> nPath = new ArrayList<>(curr.path);
                nPath.add(i);
                combo.add(new Node(tWei, tVal, nPath));
            }
        }
        int index = 0;
        List<Integer> path;
        List<Integer> maxVal = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < combo.size(); i++) {
            Node a = combo.get(i);
            if(a.value > max) {
                max = a.value;
                index = i;
            }
        }

        if(max == Integer.MIN_VALUE) {
            maxVal = new ArrayList<>();
            maxVal.add(0);
            res.add(maxVal);
            path = new ArrayList<>();
            res.add(path);
            return res;
        }

        maxVal.add(combo.get(index).value);
        path = new ArrayList<>(combo.get(index).path);
        res.add(maxVal);
        res.add(path);
        return res;
    }


}
