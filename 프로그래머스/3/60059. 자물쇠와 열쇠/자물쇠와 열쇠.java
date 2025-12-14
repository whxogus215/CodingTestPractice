class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // 회전 + 이동 -> 표본 수가 작으므로, 완전탐색!
        int N = lock.length;
        int M = key.length;
        int offset = key.length - 1;
        for(int r = 0; r < offset + lock.length; r++) {
            for(int c = 0; c < offset + lock.length; c++) {
                for(int rot = 0; rot < 4; rot++) {
                    int[][] arr = new int[2 * M + N - 2][2 * M + N - 2];
                    
                    for(int i = 0; i < N; i++) {
                        for(int j = 0; j < N; j++) {
                            arr[i + offset][j + offset] = lock[i][j];
                        }
                    }
                    
                    addKey(r, c, rot, arr, key);
                    
                    if (isOpen(arr, lock, offset)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void addKey(int r, int c, int rot, int[][] arr, int[][] key) {
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
    
    private boolean isOpen(int[][] arr, int[][] lock, int offset) {
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if (arr[i + offset][j + offset] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며
// 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다.
// 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
