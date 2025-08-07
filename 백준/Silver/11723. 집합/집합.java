import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int S = 0;

        while (M-- > 0) {
            String line = br.readLine();
            if (line.equals("all")) {
                S = 0b00000000000111111111111111111110;
            } else if (line.equals("empty")) {
                S = 0;
            } else {
                String[] split = line.split(" ");
                String command = split[0];
                int x = Integer.parseInt(split[1]);

                if (command.equals("add")) {
                    S = S | (1 << x);
                }
                if (command.equals("remove")) {
                    S = S & ~(1 << x);
                }
                if (command.equals("check")) {
                    if ((S & (1 << x)) >> x == 1) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                }
                if (command.equals("toggle")) {
                    S = S ^ (1 << x);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
