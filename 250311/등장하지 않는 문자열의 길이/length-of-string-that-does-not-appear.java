import java.util.*;

public class Main {
    
    public static int N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String line = sc.next();
        char[] alphabets = line.toCharArray();

        int count = 0;
        for(int num = 1; num < N - 1; num++) {
            boolean next = false;
            A:for(int i = 0; i + num - 1 < N; i++) {
                char[] copy = Arrays.copyOfRange(alphabets, i, i + num);
                int showCount = 0;
                for(int j = 0; j + num - 1 < N; j++) {
                    char[] compare = Arrays.copyOfRange(alphabets, j, j + num);
                    if (Arrays.equals(copy, compare)) {
                        showCount++;
                    }
                    if (showCount >= 2) {
                        next = true;
                        break A;
                    }
                }
            }
            if (!next) {
                count = num;
                break;
            }
        }

        System.out.println(count);
    }
}