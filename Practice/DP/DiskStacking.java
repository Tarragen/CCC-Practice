package Practice.DP;

import java.util.ArrayList;
import java.util.*;


    /*
    * sort first, by whatever dimension, to ensure that a smaller element is not added to the back, as to destroy results
    * same as knapsack, compare with last element unless it is element 0 or 1
    * return highest height
    * */


public class DiskStacking {
    public static void main(String[] args) {
        List<Integer[]> arguments = new ArrayList<>();
        arguments.add(new Integer[]{2,1,2});
        arguments.add(new Integer[]{4,4,5});
        arguments.add(new Integer[]{3,2,3});
        arguments.add(new Integer[]{2,2,8});
        arguments.add(new Integer[]{2,3,4});
        arguments.add(new Integer[]{1,3,1});


        List<Integer[]> res = diskStack(arguments);

        for(Integer[] a : res) {
            for(int i : a) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }

    public static List<Integer[]> diskStack(List<Integer[]> items) {
        List<Integer[]> res = new ArrayList<>();
        if(items.isEmpty()) {
            return res;
        }
        //sort
        items.sort((a, b) -> Integer.compare(a[a.length - 1], b[b.length - 1]));

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer[]> dimensions = new ArrayList<>();
        List<Integer> heights = new ArrayList<>();

        //initial element for path
        paths.add(new ArrayList<>(List.of(0)));
        dimensions.add(items.getFirst());
        heights.add(items.getFirst()[2]);

        for(int i = 1; i < items.size(); i++) {
            Integer[] currDisk = items.get(i);
            paths.add(new ArrayList<>(List.of(i)));
            dimensions.add(items.get(i));
            heights.add(items.get(i)[2]);

            int length = heights.size();
            for(int j = 0; j < length-1; j++) {
                int height = heights.get(j);
                Integer[] dimension = dimensions.get(j);
                List<Integer> path = paths.get(j);

                if(dimension[0] < currDisk[0] && dimension[1] < currDisk[1] && dimension[2] < currDisk[2]) { //all dimensions are smaller
                    dimensions.add(currDisk);
                    List<Integer> tempPath = new ArrayList<>(path);
                    tempPath.add(i);
                    paths.add(tempPath);
                    heights.add(height+currDisk[2]); //add new height
                }
            }
        }
        int index = 0; int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.size(); i++) {
            if(heights.get(i) > max) {
                index = i;
                max = heights.get(i);
            }
        }

        List<Integer> path = paths.get(index);
        for(int i : path) {
            res.add(items.get(i));
        }

        return res;
    }


}
