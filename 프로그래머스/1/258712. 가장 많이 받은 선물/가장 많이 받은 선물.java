import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Data> logs = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            logs.put(friends[i], new Data(i, 0, 0));
        }
        
        int[][] giftLogs = new int[friends.length][friends.length];
        for(int i = 0; i < gifts.length; i++) {
            String[] splited = gifts[i].split(" ");
            int fromIndex = logs.get(splited[0]).index;
            int toIndex = logs.get(splited[1]).index;     
            giftLogs[fromIndex][toIndex]++;
        }
        
        // 선물지수 계산하기
        for(String name : friends) {
            int index = logs.get(name).index;
            int giveCount = 0;
            for(int i = 0; i < giftLogs[index].length; i++) {
                giveCount += giftLogs[index][i];
            }
            int getCount = 0;
            for(int i = 0; i < giftLogs.length; i++) {
                getCount += giftLogs[i][index];
            }
            logs.get(name).giftValue = (giveCount - getCount);
        }
        
        // gifts의 기록을 Set으로 저장
        Set<String> allGiftLogs = new HashSet<>();
        for(String log : gifts) {
            allGiftLogs.add(log);
        }
        
        // nC2의 조합마다 선물 개수 카운트하기 (이중 for문)
        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                String name1 = friends[i]; 
                String name2 = friends[j];
                
                int name1Index = logs.get(name1).index;
                int name2Index = logs.get(name2).index;
                
                int count1 = giftLogs[name1Index][name2Index];
                int count2 = giftLogs[name2Index][name1Index];
                
                String log1 = name1 + " " + name2;
                String log2 = name2 + " " + name1;
                
                if ((!allGiftLogs.contains(log1) && !allGiftLogs.contains(log2))
                    || (count1 == count2)) {
                    int name1GiftValue = logs.get(name1).giftValue;
                    int name2GiftValue = logs.get(name2).giftValue;

                    if (name1GiftValue == name2GiftValue) {
                        continue;                         
                    } else if (name1GiftValue < name2GiftValue) {
                        logs.get(name2).nextCount++;
                    } else {
                        logs.get(name1).nextCount++;
                    }
                    continue;
                }
                
                if (count1 < count2) {
                    logs.get(name2).nextCount++;
                } else {
                    logs.get(name1).nextCount++;
                }
            }
        }
        
        return logs.values().stream().map(d -> d.nextCount).mapToInt(Integer::intValue).max().getAsInt();
    }
    
    static class Data {
    int index;
    int giftValue;
    int nextCount;
    
    public Data(int index, int giftValue, int nextCount) {
        this.index = index;
        this.giftValue = giftValue;
        this.nextCount = nextCount;
    }
}
}

