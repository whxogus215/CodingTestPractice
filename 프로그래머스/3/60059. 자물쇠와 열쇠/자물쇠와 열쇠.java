class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;
        
        for(int r = 0; r < offset + lock.length; r++) {
            for(int c = 0; c < offset + lock.length; c++) {
                for(int rot = 0; rot < 4; rot++) { // 시계 방향으로 회전
                    int[][] arr = new int[58][58];
                    
                    // 자물쇠 채우기
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            arr[i + offset][j + offset] = lock[i][j];
                        }    
                    }
                    
                    simulate(arr, rot, r, c, key);
                    if (check(arr, lock, offset)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void simulate(int[][] arr, int rot, int r, int c, int[][] key) {
        int n = key.length;
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                if (rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rot == 1) {
                    arr[r + i][c + j] += key[j][n - i - 1];
                } else if (rot == 2) {
                    arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
                } else {
                    arr[r + i][c + j] += key[n - 1 - j][i];
                }
            }
        }
    }
    
    private boolean check(int[][] arr, int[][] lock, int offset) {
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if (arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

// 열쇠의 돌기 - 자물쇠의 홈 (O)
// 열쇠의 돌기 - 자물쇠의 돌기 (X)

// 좌표의 회전(시계/반시계), 이동(상하좌우), 데이터 크기가 작으므로 완전탐색
// 2차원 배열

