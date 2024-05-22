class Solution {
    /**
     * 1. 한 대기실에 대한 검사 로직을 5번 반복한다.
     * 2. 한 대기실은 String[]로 제공되며, 상하좌우 좌표로 접근하기 위해 이차원 배열로 변경한다. O
     * 3. P인 지점을 기준으로 상하좌우 검사를 통해 X, O, P인지에 따라 다른 로직을 수행한다.
     * 3-1. P 옆에 X가 있을 경우, 해당 방향은 거리두기를 모두 준수하므로 Pass
     * 3-2. P 옆에 O가 있을 경우, O인 지점을 기준으로 세 방향 탐색 했을 때 P가 나오면 False
     * 3-3. P 옆에 P가 있을 경우, 바로 False
     */
    private final int[] dy = {-1, 0, 0, 1};
    private final int[] dx = {0, -1, 1, 0};

    public int[] solution(String[][] places) {
        int answer[] = new int[places.length];        
        
        for (int i = 0; i < places.length; i++) { // 5번 로직이 반복된다.
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < place.length; j++) {
                room[j] = place[j].toCharArray(); // 이차원 문자형 배열로 변환
            }
            
            if (!isDistanced(room)) { // 거리두기 준수하지 않을 시, 0 저장
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    private boolean isDistanced(char[][] room) {
        // 해당 룸의 모든 좌표를 탐색한다.
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] == 'P') { // P인 지점에 대해서만 검사
                    if (!isDistanced(room, y, x)) return false;
                }
            }
        }
        return true;
    }
    
    private boolean isDistanced(char[][] room, int y, int x) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            if (room[ny][nx] == 'P') return false;
            if (room[ny][nx] == 'O') { // O인 지점을 기준으로 세방향 탐색
                if (isNextToPerson(room, ny, nx, 3 - d)) return false; // O 옆에 P가 또 있는 것이므로 false 반환
            }
        }
        return true;
    }
    
    private boolean isNextToPerson(char[][] room, int y, int x, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true; // O 지점 옆에 P가 있음
        }
        return false;
    }
}
