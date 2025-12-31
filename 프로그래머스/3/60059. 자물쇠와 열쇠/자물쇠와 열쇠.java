class Solution {
    
    private int N, M;
    
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        
        for(int r = 0; r < N + M - 1; r++) {
            for(int c = 0; c < N + M - 1; c++) {
                for(int rot = 0; rot < 4; rot++) {
                    int[][] arr = new int[2 * M + N - 2][2 * M + N - 2];
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            arr[i + M - 1][j + M - 1] = lock[i][j];
                        }
                    }
                    simulate(r, c, rot, arr, key);

                    if (isCorrect(arr, lock)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void simulate(int r, int c, int rot, int[][] arr, int[][] key) {
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                if (rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) { // 0, 1 -> 1, 2 // 1, 2 -> 2, 1
                    arr[r + i][c + j] += key[j][M - 1 - i];
                } else if (rot == 2) { // 0, 1 -> 2, 1 // 1, 2 -> 1, 0
                    arr[r + i][c + j] += key[M - 1 - i][M - 1 - j];
                } else { // 0, 1 -> 1, 0
                    arr[r + i][c + j] += key[M - 1 - j][i];
                }
            }
        }
    }
    
    private boolean isCorrect(int[][] arr, int[][] lock) {
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if (arr[i + M - 1][j + M - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 키에 대한 회전 + 이동 조합으로 자물쇠가 열리는지 판단하는 완탐