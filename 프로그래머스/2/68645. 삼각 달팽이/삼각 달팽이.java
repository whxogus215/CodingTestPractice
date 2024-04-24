class Solution {

    /**
     * 1. 아래로 배열 채우기 -> 오른쪽으로 배열 채우기 -> 왼쪽 위 대각선으로 배열 채우기 (반복) 2. (0,0)에서 시작 3. while(true)로 반복
     * 2. 이차원 배열을 일차원 배열로 변환
     */
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int number = 1;
        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = number++;
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1; // 아래로 이동
            }
            if (x + 1 == n || triangle[y][x + 1] != 0) break;
            x += 1;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = number++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }
            if (triangle[y - 1][x - 1] != 0) break;
            x -= 1;
            y -= 1;

            // 왼쪽 위대각선으로 이동
            while (true) {
                triangle[y][x] = number++;
                if (triangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y += 1;
        }

        int[] result = new int[number - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        
        return result;
    }

}
