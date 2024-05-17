class Solution {

    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int y = 0;
        int x = 0;
        

        while (true) {
            // 아래로 내려가기
            while (true) {
                matrix[y][x] = value++;
                if (y + 1 >= n || matrix[y + 1][x] != 0) break;
                y += 1;
            }
            // 아래로 채우는게 마지막일 경우, while문을 다시 빠져나와야 함
            if (x + 1 >= n || matrix[y][x + 1] != 0) break;
            // 오른쪽으로 가기
            x += 1;
            while (true) {
                matrix[y][x] = value++;
                if (x + 1 >= n || matrix[y][x + 1] != 0) break;
                x += 1;
            }
            // 오른쪽으로 채우는게 마지막일 경우, while문을 다시 빠져나와야 함
            if (matrix[y - 1][x - 1] != 0) break;
            // 왼쪽 대각선으로 가기
            y -= 1;
            x -= 1;
            while (true) {
                matrix[y][x] = value++;
                if (matrix[y - 1][x - 1] != 0) break;
                y -= 1;
                x -= 1;
            }
            // 왼쪽 대각선으로 채우는게 마지막일 경우, while문을 다시 빠져나와야 함
            if (y + 1 >= n || matrix[y + 1][x] != 0) break;
            y += 1;
        }

        int[] answer = new int[value - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = matrix[i][j];
            }
        }

        return answer;
    }

}
