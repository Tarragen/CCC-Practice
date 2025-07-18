import java.util.*;
public class j5_00_surfing_s3 {
    static HashMap<String, HashSet<String>> allSites;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int websitesToBeEntered = Integer.parseInt(sc.nextLine());
        allSites = new HashMap<>();

        for (int i = 0; i < websitesToBeEntered; i++) {
            String website = sc.next();

            if(sc.next().contains("<HTML>")) {
                while(!sc.next().equals("</HTML>")) {
                    String currLine = sc.nextLine();
                    while (currLine.contains("<A")) {
                        int tempS = currLine.indexOf("HREF=") + 6;
                        int tempE = currLine.indexOf("\">");
                        String newSite = currLine.substring(tempS, tempE);
                        allSites.computeIfAbsent(website, e -> new HashSet<>()).add(newSite);
                        currLine = currLine.substring(currLine.indexOf("\">") + 2);
                        System.out.println("Link from " + website + " to " + newSite);
                    }
                }
            }
            sc.nextLine();
        }
        while(true) {
            String start = sc.next();
            String end = sc.next();
            if (end.equals("End")) {
                break;
            }
            bfs(start, end);
        }
    }

    private static void bfs(String start, String end) {
        ArrayList<String> queue = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            ArrayList<String> nextLvl = new ArrayList<>();
            for(String s : queue) {
                if (s.equals(end)) {
                    System.out.println("Can surf from " + start + " to " + end + ".");
                    return;
                }
                HashSet<String> temp = allSites.get(s);
                if(temp != null) {
                    nextLvl.addAll(temp);
                }
            }
            queue = new ArrayList<>(nextLvl);
        }
        System.out.println("Can't surf from " + start + " to " + end + ".");
    }
}
