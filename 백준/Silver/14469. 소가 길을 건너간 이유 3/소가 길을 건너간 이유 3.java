import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] times = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (t1, t2) -> Integer.compare(t1[0], t2[0]));

        int start = times[0][0];
        int end = times[0][0] + times[0][1];
        for(int i = 1; i < N; i++) {
            if (times[i][0] < end) {
                start = end;
            } else {
                start = times[i][0];
            }
            end = start + times[i][1];
        }
        
        System.out.println(end);
    }
}
