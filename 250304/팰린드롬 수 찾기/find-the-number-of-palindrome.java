import java.util.*;

public class Main {
    
    public static int X, Y;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();

        int count = 0;

        for(int num = X; num <= Y; num++) {
            String value = num + "";
            char[] arr = value.toCharArray();
            boolean isPell = true;
            for(int i = 0; i < arr.length / 2; i++) {
                int j = (arr.length - 1) - i;
                if (j <= i) {
                    break;
                }
                if (arr[i] != arr[j]) {
                    isPell = false;
                    break;
                }
            }
            if (isPell) {
                count++;
            }
        }

        System.out.println(count);
    }
}