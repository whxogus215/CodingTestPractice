import java.util.Scanner;
public class Main {

    public static final int OFFSET = 2000;
    public static final int MAX_SIZE = 4001;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cPos = OFFSET;
        int nPos;

        int[] arr = new int[MAX_SIZE];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            if (dir == 'L') {
                nPos = cPos - x;
                for(int j = nPos; j < cPos; j++) {
                    arr[j]++;                    
                }
            } else {
                nPos = cPos + x;
                for(int j = cPos; j < nPos; j++) {
                    arr[j]++;
                }
            }

            cPos = nPos;
        }

        int size = 0;
        for(int i = 0; i < MAX_SIZE; i++) {
            if (arr[i] >= 2) {
                size++;
            }
        }
        System.out.println(size);
    }
}