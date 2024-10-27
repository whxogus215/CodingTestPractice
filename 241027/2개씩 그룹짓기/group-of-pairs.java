import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_N = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[2 * MAX_N];

        for(int i = 0; i < 2 * n; i++)
            nums[i] = sc.nextInt();

        // nums[0]부터 nums[2n - 1]까지를 정렬함
        Arrays.sort(nums, 0, 2 * n);

        int groupMax = 0;
        for(int i = 0; i < n; i++) {
            // i번째와 2n - 1 - i번째 원소를 매칭
            int groupSum = nums[i] + nums[2*n - 1 - i];
            if(groupSum > groupMax)
                // 최댓값 갱신
                groupMax = groupSum;
        }

        System.out.print(groupMax);

    }
}