package Graph;

public class NumberOfIslands {
    /**
     * 그래프를 구성하는 방법으로는 2차원 배열 또는 Map<Integer, List<Integer>> 방식이 있다.
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void DFS(char[][] grid, int y, int x) {
        /**
         * x >= grid[0].length에서 grid.length로 하면 안되는 이유
         * - 그래프가 정사각형이 아닌 5 * 3처럼 행과 열의 개수가 다를 수 있다. 따라서 x축을 탐색하는 범위는
         *   반드시 grid[0].length와 같이 지정해야 한다.
         *
         * grid[y][x] == '0'이 조건식의 맨 뒤에 있는 이유
         * - y와 x의 인덱스 범위가 0보다 작거나 배열의 길이보다 클 수 있다. 만약, 이런 상황에서
         *   grid[y][x]와 같이 배열의 요소에 접근할 경우, ArrayIndexOut 예외가 발생한다.
         *   따라서 이러한 경우에 바로 필터링을 할 수 있도록 배열에 접근하는 코드는 맨 마지막에 있어야 한다.
         */
        if (y >= grid.length || y < 0 || x >= grid[0].length || x < 0 || grid[y][x] == '0') {
            return ;
        }
        grid[y][x] = '0';

        DFS(grid, y + 1, x);
        DFS(grid, y - 1, x);
        DFS(grid, y, x + 1);
        DFS(grid, y, x - 1);
    }
}
