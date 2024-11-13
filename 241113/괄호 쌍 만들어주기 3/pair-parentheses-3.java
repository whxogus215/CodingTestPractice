import java.util.*;

public class Main {

    public static void main(String[] args) {
        // (가 나오는 지점에서 탐색 시작 -> )가 나오면 cnt++
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] arr = line.toCharArray();

        int count = 0;
        for(int i = 0; i < line.length(); i++) {
            if (arr[i] != '(') {
                continue;
            }
            for(int j = i + 1; j < line.length(); j++) {
                if (arr[j] == ')') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}