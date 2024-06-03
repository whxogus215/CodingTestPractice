class Solution {
    /**
     * 1. i행 j열의 값은 arr1의 i행과 arr2의 j열의 원소를 곱한 값이다.
     * - answer의 크기는 arr1의 행 크기 X arr2의 열 크기 이다.
     * 2. 이 때, 곱해지는 요소들의 순서는 같다. 즉, arr1의 첫 번째 요소는 arr2의 첫 번째 요소와 곱해진다.
     * 3. 곱해진 값들끼리 더해서 최종 값을 answer의 i행 j열에 추가한다.
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                int sum = 0;
                // arr1의 열 개수만큼 반복
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += (arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}