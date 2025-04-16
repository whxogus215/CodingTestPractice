import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        
        int result = convertTen(binary);
        System.out.println(convertTwo(result * 17));
    }

    public static int convertTen(String binary) {
        int sum = 0;
        for(int i = 0; i < binary.length(); i++) {
            sum = sum * 2 + (binary.charAt(i) - '0');
        }
        return sum;
    }

    public static String convertTwo(int digit) {
        int[] binary = new int[20];
        int cnt = 0;
        
        while(true) {
            if (digit < 2) {
                binary[cnt] = digit % 2;
                break;
            }

            binary[cnt++] = digit % 2;
            digit /= 2;
        }

        String result = "";
        for(int i = cnt; i >= 0; i--) {
            result += binary[i];
        }
        return result;
    }
}