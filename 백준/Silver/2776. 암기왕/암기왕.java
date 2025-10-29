import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }
            
            int M = Integer.parseInt(br.readLine());
            int[] note2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                note2[i] = Integer.parseInt(st.nextToken());
            }
    
            Arrays.sort(note1);
            for(int i = 0; i < M; i++) {
                if (binarySearch(note2[i], note1)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int target, int[] arr) {
        int left = 0;
        int right = N - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
