import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<Music>> musics = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            if (!musics.containsKey(genres[i])) {
                musics.put(genres[i], new ArrayList<>());
            }
            musics.get(genres[i]).add(new Music(genres[i], i, plays[i]));
        }
        List<String> genreNames = new ArrayList<>(genreCount.keySet());
        Collections.sort(genreNames, (g1, g2) -> Integer.compare(genreCount.get(g2), genreCount.get(g1)));
        
        List<Integer> answer = new ArrayList<>();
        for(String name : genreNames) {
            List<Music> list = musics.get(name);
            Collections.sort(list, (m1, m2) -> Integer.compare(m2.playCount, m1.playCount)); // Stable Sort
            
            list.stream().limit(2).forEach(m -> answer.add(m.number)); // 최대 2개까지만 꺼내서 저장 -> 스트림 활용
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Music {
    String genre;
    int number;
    int playCount;
    
    public Music(String genre, int number, int playCount) {
        this.genre = genre;
        this.number = number;
        this.playCount = playCount;
    }
}