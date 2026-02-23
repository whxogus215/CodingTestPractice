import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> storage = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String password = st.nextToken();
            storage.put(url, password);
        }

        for(int i = 0; i < M; i++) {
            String url = br.readLine();
            bw.write(storage.get(url) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
