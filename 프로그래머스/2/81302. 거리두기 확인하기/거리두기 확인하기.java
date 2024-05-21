class Solution {

    private static final int dy[] = {-1, 0, 0, 1};
    private static final int dx[] = {0, -1, 1, 0};

    /**
     * 1. 대기실의 모든 좌표를 탐색한다.
     * 2. 상하좌우로 탐색 시, 빈 테이블이 있을 경우, 해당 위치로 이동하여 주변을 탐색한다.
     * 3. 이 때, 응시자가 발견될 경우, 거리두기를 지키지 않은 것으로 처리한다.
     *
     * ** String[]를 char[][]로 변환한다!!!!
     *
     * *** 메서드 구현순서
     * 대기실이 여러 개 -> 각 대기실마다 로직을 적용 -> 각 대기실을 이차원 배열로 변환 -> 변환한 이차원 배열을 매개변수로 하여 검사
     * -> 응시자가 있는 좌표에 대해 거리두기 검사(메서드 오버로딩)
     */

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            // String[]을 char[][]로 변환한다.
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            // 변환된 char[][]의 좌표를 하나하나 탐색하며 거리두기를 검사한다.
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue; // 응시자가 없을 경우 Pass!
                // P인 지점의 좌표를 전달하여 거리두기를 확인한다.
                if (!isDistanced(room,x,y)) return false; // 거리두기 결과 값이 false일 경우, 거리두기 지키지 않은 것으로 간주!
            }
        }
        // 모든 탐색을 마칠 경우, 거리두기를 지킨 것으로 간주
        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) { // room[y][x]에 대한 거리두기 검사
        // P인 지점에 대한 검사이므로 4 방향에 대해 탐색하기
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            switch (room[ny][nx]) {
                case 'P': return false; // P 옆에 P가 있으면 false;
                case 'O': // O인 지점에서 상하좌우 P 있는지 검사
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        // 모든 탐색을 마칠 경우, 거리두기를 지킨 것으로 간주
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        // 검사를 한 방향은 제외하고 검사해야 함
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false; // 주변에 P가 없다는 뜻
    }

}
