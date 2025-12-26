class Solution {
    public int solution(int n, int[] stations, int w) {
        int cursor = 1;
        int needCount = 0;
        for(int i = 0; i < stations.length; i++) {
            int left = stations[i] - w;
            int right = stations[i] + w;
            if (left > cursor) {
                int width = left - cursor;
                needCount += width / (2 * w + 1);
                if (width % (2 * w + 1) != 0) {
                    needCount += 1;
                }
            }
            cursor = right + 1;
        }
        
        if (cursor <= n) {
            needCount += (n - cursor + 1) / (2 * w + 1);
            if ((n - cursor + 1) % (2 * w + 1) != 0) {
                needCount++;
            }
        }
        
        return needCount;
    }
}