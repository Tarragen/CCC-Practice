import java.util.*;
import java.io.*;

public class s3_23_palindromicPosters {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int height = readInt(), width = readInt(), row = readInt(), col = readInt();
        StringBuilder sb = new StringBuilder();

        if (row == 1 && col == 1) {
            String rowStr = "a" + "b".repeat(width - 1) + "\n";
            sb.append(rowStr.repeat(height - 1));
            sb.append("a".repeat(width));
        } else if (row == 0 && col == 0) {
            sb.append("b").append("a".repeat(width - 1)).append("\n");
            String rowStr = "a" + "b".repeat(width - 1) + "\n";
            sb.append(rowStr.repeat(height - 1));
        } else if (row == height && col == width) {
            String rowStr = "a".repeat(width) + "\n";
            sb.append(rowStr.repeat(height));
        } else if (row == 0 && col == width) {
            String rowStr = "a" + "b".repeat(width - 1) + "\n";
            sb.append(rowStr.repeat(height));
        } else if (row == height && col == 0) {
            sb.append("a".repeat(width)).append("\n");
            String rowStr = "b".repeat(width) + "\n";
            sb.append(rowStr.repeat(height - 1));
        } else if (row == 0) {
            String row1 = "a".repeat(col) + "b".repeat(width - col) + "\n";
            String row2 = "a".repeat(col) + "c".repeat(width - col) + "\n";
            sb.append(row1).append(row2.repeat(height - 1));
        } else if (col == 0) {
            String row1 = "a".repeat(width) + "\n";
            String row2 = "b" + "c".repeat(width - 1) + "\n";
            sb.append(row1.repeat(row)).append(row2.repeat(height - row));
        } else if (row == height) {
            if (col % 2 == 1 && width % 2 == 0) {
                System.out.println("IMPOSSIBLE");
                return;
            } else if (col % 2 == 0) {
                String symCols = "a".repeat(col / 2);
                sb.append(symCols).append("b".repeat(width - col)).append(symCols).append("\n");
                String rowStr = "a".repeat(width) + "\n";
                sb.append(rowStr.repeat(height - 1));
            } else {
                String asymCols = "b".repeat((width - col) / 2);
                sb.append(asymCols).append("a".repeat(col)).append(asymCols).append("\n");
                String rowStr = "a".repeat(width) + "\n";
                sb.append(rowStr.repeat(height - 1));
            }
        } else if (col == width) {
            if (row % 2 == 1 && height % 2 == 0) {
                System.out.println("IMPOSSIBLE");
                return;
            } else {
                String asymRows = ("b" + "a".repeat(width - 1) + "\n").repeat((height - row) / 2);
                String rowStr = "a".repeat(width) + "\n";
                sb.append(asymRows).append(rowStr.repeat(row)).append(asymRows);
            }
        } else {
            String row1 = "b".repeat(Math.min(col, width / 2)) + "a".repeat(width - col * 2) + "b".repeat(Math.min(col, (int) Math.ceil(width / 2.0))) + "\n";
            String row2 = "b".repeat(col) + "c".repeat(width - col) + "\n";
            sb.append(row1.repeat(row)).append(row2.repeat(height - row));
        }

        System.out.print(sb);

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
