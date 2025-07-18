import java.util.*;
//! adjacency matrix faster than hashmap + hashset
public class j5_01_strategicBombing_s3 {
    static final int offset = 65;
    static boolean[][] adjMat = new boolean[26][26];
    static int count = 0;
    static Set<String> segments = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String road = scanner.nextLine();
            if (road.equals("**")) {
                break;
            }
            segments.add(road);
            char source = road.charAt(0);
            char destination = road.charAt(1);
            adjMat[(int) source - offset][(int) destination - offset] = true;
            adjMat[(int) destination - offset][(int) source - offset] = true;
            //add input and connecting points to adjacency matrix
        }

        for(String segment : segments) {
            char start = segment.charAt(0);
            char end = segment.charAt(1);
            //simulates bombing the road segment
            adjMat[(int) start - offset][(int) end - offset] = false;
            adjMat[(int) end - offset][(int) start - offset] = false;
            checkConnect(segment);
            //reset
            adjMat[(int) start - offset][(int) end - offset] = true;
            adjMat[(int) end - offset][(int) start - offset] = true;
        }

        System.out.println("There are " + count + " disconnecting roads.");
    }

    //basically a bfs
    static void checkConnect(String segment) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if(current == 1) {
                return;
            }
            for (int i = 0; i < 26; i++) {
                if (adjMat[current][i] && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        if (!visited[1]) {
            System.out.println(segment);
            count++;
        }
    }
}