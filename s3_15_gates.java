import java.util.*;
import java.io.*;

public class s3_15_gates {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> ports = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int mostPlanes = 0;
        int gates = readInt();
        int planes = readInt();

        for(int i = 1; i <= gates; i++) {
            ports.add(i);
        }

        int dockable;
        for(int i = 0; i < planes; i++) {
            dockable = readInt();
            int portNum = binSearchIndex(dockable);
            if(portNum == -1) {
                break;
            } else {
                ports.remove(portNum);
                mostPlanes++;
            }

            if(mostPlanes == gates) {
                break;
            }
        }
        System.out.println(mostPlanes);
    }

    static int binSearchIndex(int desiredPort) {
        int left = 0, right = ports.size()-1;
        int mid, curr;

        while(left <= right) {
            mid = (right-left)/2 + left;
            curr = ports.get(mid);
            if(mid+1>=ports.size()) {
                if(curr <= desiredPort) {
                    return mid;
                }
                return -1;
            }
            boolean large = ports.get(mid+1) > desiredPort;

            if(curr == desiredPort) {
                return mid;
            } else if(curr < desiredPort && large) {
                return mid;
            } else if(large) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    static String next() throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
