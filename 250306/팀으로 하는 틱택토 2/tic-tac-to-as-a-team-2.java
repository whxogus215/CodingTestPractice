import java.util.*;

public class Main {
    
    public static int[][] arr = new int[3][3];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            String line = sc.nextLine();
            char[] ch = line.toCharArray();
            for(int j = 0; j < ch.length; j++) {
                arr[i][j] = ch[j] - ' ';
            }
        }

        Set<String> result = new HashSet<>();

        // 가로 줄 탐색 (3개)
        for(int i = 0; i < 3; i++) {
            int[] row = new int[]{arr[i][0], arr[i][1], arr[i][2]};
            Arrays.sort(row);
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < 3; j++) {
                set.add(row[j]);
            }
            if (set.size() == 2) {
                int[] newArr = set.stream().mapToInt(Integer::intValue).toArray();
                String key = newArr[0] + " " + newArr[1];
                result.add(key);
            }
        }

        // 세로 줄 탐색 (3개)
        for(int i = 0; i < 3; i++) {
            int[] row = new int[]{arr[0][i], arr[1][i], arr[2][i]};
            Arrays.sort(row);
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < 3; j++) {
                set.add(row[j]);
            }
            if (set.size() == 2) {
                int[] newArr = set.stream().mapToInt(Integer::intValue).toArray();
                String key = newArr[0] + " " + newArr[1];
                result.add(key);
            }
        }

        // 하강 대각선 탐색
        int[] row1 = new int[]{arr[0][0], arr[1][1], arr[2][2]};
        Arrays.sort(row1);
        Set<Integer> set1 = new HashSet<>();
        for(int j = 0; j < 3; j++) {
            set1.add(row1[j]);
        }
        if (set1.size() == 2) {
            int[] newArr = set1.stream().mapToInt(Integer::intValue).toArray();
            String key = newArr[0] + " " + newArr[1];
            result.add(key);
        }

        // 상승 대각선 탐색
        int[] row2 = new int[]{arr[2][0], arr[1][1], arr[0][2]};
        Arrays.sort(row2);
        Set<Integer> set2 = new HashSet<>();
        for(int j = 0; j < 3; j++) {
            set2.add(row2[j]);
        }
        if (set2.size() == 2) {
            int[] newArr = set2.stream().mapToInt(Integer::intValue).toArray();
            String key = newArr[0] + " " + newArr[1];
            result.add(key);
        }

        System.out.println(result.size());
    }
}