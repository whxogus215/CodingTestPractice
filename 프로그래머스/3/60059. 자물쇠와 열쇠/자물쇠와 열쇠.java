class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;
        for(int r = 0; r < offset + lock.length; r++) {
            for(int c = 0; c < offset + lock.length; c++) {
                for(int rot = 0; rot < 4; rot++) {
                    int m = key.length;
                    int n = lock.length;
                    int[][] arr = new int[2 * m + n - 2][2 * m + n - 2];
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            arr[i + offset][j + offset] = lock[i][j];
                        }
                    }
                    
                    simulate(arr, key, r, c, rot);
                    
                    if (isCorrect(arr, lock, offset)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void simulate(int[][] arr, int[][] key, int r, int c, int rot) {
        int n = key.length;
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                if (rot == 0) {
                    arr[i + r][j + c] += key[i][j];
                } else if (rot == 1) {
                    arr[i + r][j + c] += key[j][n - 1 - i];
                } else if (rot == 2) {
                    arr[i + r][j + c] += key[n - 1 - i][n - 1 - j];
                } else {
                    arr[i + r][j + c] += key[n - 1 - j][i];
                }
            }
        }
    }
    
    private boolean isCorrect(int[][] arr, int[][] lock, int offset) {
        for(int i = offset; i < offset + lock.length; i++) {
            for(int j = offset; j < offset + lock.length; j++) {
                if (arr[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 자물쇠의 홈 + 열쇠의 돌기 O -> lock의 모든 영역이 정확히 1이어야 True
// 자물쇠의 돌기 + 열쇠의 돌기 X