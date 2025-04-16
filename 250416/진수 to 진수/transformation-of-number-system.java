import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        
        int sum = 0;
        for(int i = 0; i < N.length(); i++) {
            sum = sum * A + (N.charAt(i) - '0');
        }

        int[] arr = new int[20];
        int cnt = 0;
        while(true) {
            if (sum < B) {
                arr[cnt] = sum % B;
                break;
            }
            arr[cnt++] = sum % B;
            sum /= B;
        }

        for(int i = cnt; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}