import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());

        Set<Integer> S = new HashSet<>();
        List<Integer> allElements = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        while (M-- > 0) {
            String line = br.readLine();
            if (line.equals("all")) {
                S = new HashSet<>(allElements);
            } else if (line.equals("empty")) {
                S.clear();
            } else {
                String[] split = line.split(" ");
                String command = split[0];
                int x = Integer.parseInt(split[1]);

                if (command.equals("add")) {
                    S.add(x);
                }
                if (command.equals("remove")) {
                    S.remove(x);
                }
                if (command.equals("check")) {
                    if (S.contains(x)) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                }
                if (command.equals("toggle")) {
                    if (S.contains(x)) {
                        S.remove(x);
                    } else {
                        S.add(x);
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
