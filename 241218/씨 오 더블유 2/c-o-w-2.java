import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] cArr = sc.next().toCharArray();

        int count = 0;
        for(int i = 0; i < cArr.length - 2; i++) {
            if (cArr[i] == 'C') {
                for(int j = i + 1; j < cArr.length - 1; j++) {
                    if (cArr[j] == 'O') {
                        for(int k = j + 1; k < cArr.length; k++) {
                            if (cArr[k] == 'W') {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}