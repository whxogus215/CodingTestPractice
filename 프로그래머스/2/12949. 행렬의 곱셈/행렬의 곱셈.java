class Solution {
    /**
     * 1. i행 j열의 값은 arr1의 i행과 arr2의 j열의 원소를 곱한 값이다.
     * - answer의 크기는 arr1의 행 크기 X arr2의 열 크기 이다.
     * 2. 이 때, 곱해지는 요소들의 순서는 같다. 즉, arr1의 첫 번째 요소는 arr2의 첫 번째 요소와 곱해진다.
     * 3. 곱해진 값들끼리 더해서 최종 값을 answer의 i행 j열에 추가한다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;


        int[][] answer = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
