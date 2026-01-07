class Solution {
    
    private int W;
    
    public int solution(int n, int[] stations, int w) {
        W = 2 * w + 1;
        int count = 0;
        int cursor = 1;
        for(int i = 0; i < stations.length; i++) {
            int left = stations[i] - w;
            int right = stations[i] + w;
            if (cursor >= left) {
                cursor = right + 1;
                continue;
            }
            int width = left - cursor;
            count += (width / W);
            if (width % W != 0) {
                count += 1;
            }
            cursor = right + 1;
        }
        if (cursor <= n) {
           int width = n - cursor + 1;
            count += (width / W);
            if (width % W != 0) {
                count += 1;
            } 
        }

        return count;
    }
}