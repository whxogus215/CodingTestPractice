import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (l1, l2) -> {
            if (l1[0] == l2[0]) {
                return Integer.compare(l1[1], l2[1]);
            }
            return Integer.compare(l1[0], l2[0]);            
        });
        
        int start = lines[0][0];
        int end = lines[0][1];
        int totalLength = 0;
        
        for(int i = 1; i < N; i++) {
            int x = lines[i][0];
            int y = lines[i][1];

            if (x <= end) {
                end = Math.max(end, y);
            } else {
                totalLength += (end - start);
                start = x;
                end = y;
            }
        }
        totalLength += (end - start);
        
        System.out.println(totalLength);
    }
}
