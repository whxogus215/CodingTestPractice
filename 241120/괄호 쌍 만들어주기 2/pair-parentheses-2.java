import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        char[] arr = line.toCharArray();
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '(') {
                if (arr[i + 1] == ')') {
                    continue;
                }
                for(int j = i + 2; j < arr.length - 1; j++) {
                    if (arr[j] == ')') {
                        if (arr[j + 1] == ')') {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}