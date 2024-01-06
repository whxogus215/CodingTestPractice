import java.util.*;

class Main {
  static int N, K, cnt;
  static int[] arr;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    K = sc.nextInt();
    arr = new int[N];
    
    for(int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    int idx = N - 1;
    while (K > 0) {
      if (arr[idx] > K && idx >= 0) {
        idx--;
        continue;
      }

      cnt += K / arr[idx];
      K %= arr[idx];
    }

    System.out.println(cnt);
    sc.close();
  }
}