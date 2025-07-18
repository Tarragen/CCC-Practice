import java.util.*;
public class j5_18_chooseYourOwnPath {
    static class Page {
        public int pathNum;
        public int[] paths;
    }

    public static void main(String[] args) {
        int shortestPath = Integer.MAX_VALUE;
        List<Page> allPages = new ArrayList<>();
        Deque<Page> queue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int pages = Integer.parseInt(sc.nextLine());
        boolean[] reachablePages = new boolean[pages];

        for(int i = 0; i < pages; i++) {
            String[] line = sc.nextLine().split(" ");
            int options = Integer.parseInt(line[0]);
            Page p = new Page();
            p.pathNum = options;
            if(options > 0) {
                int[] tempPaths = new int[options];
                for (int j = 0; j < options; j++) {
                    tempPaths[j] = Integer.parseInt(line[j + 1]);
                }
                p.paths = tempPaths;
            }
            allPages.add(p);
        }
        queue.add(allPages.getFirst());
        reachablePages[0] = true;

        int count = 1;
        while(!queue.isEmpty()) {
            ArrayList<Page> next = new ArrayList<>();
            for(Page p : queue) {
                int[] pathways = p.paths;
                if(p.pathNum == 0) {
                    if(count < shortestPath) {
                        shortestPath = count;
                    }
                } else {
                    for(int i : pathways) {
                        if(!reachablePages[i-1]) {
                            reachablePages[i-1] = true;
                            next.add(allPages.get(i-1));
                        }
                    }
                }
            }
            queue = new ArrayDeque<>(next);
            count++;
        }

        boolean works = true;
        for(boolean reachable : reachablePages) {
            if(!reachable) {
                System.out.println("N");
                works = false;
                break;
            }
        }
        if(works) {
            System.out.println("Y");
        }
        System.out.println(shortestPath);

    }
}
