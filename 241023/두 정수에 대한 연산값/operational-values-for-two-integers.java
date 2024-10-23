import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = {a, b};

        swap(a, b, arr);

        System.out.println(arr[0] + " " + arr[1]);
    }

    public static void swap(int a, int b, int[] arr) {
        if (a > b) {
            a += 25;
            b *= 2;
        } else {
            a *= 2;
            b += 25;
        }

        arr[0] = a;
        arr[1] = b;
    }
}