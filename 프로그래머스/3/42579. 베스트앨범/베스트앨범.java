import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<Music>> musics = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            if (!musics.containsKey(genres[i])) {
                List<Music> list = new ArrayList<>();
                list.add(new Music(genres[i], i, plays[i]));
                musics.put(genres[i], list);
            } else {
                musics.get(genres[i]).add(new Music(genres[i], i, plays[i]));
            }
        }
        List<String> genreNames = new ArrayList<>(genreCount.keySet());
        Collections.sort(genreNames, (g1, g2) -> Integer.compare(genreCount.get(g2), genreCount.get(g1)));
        
        
        
        List<Integer> answer = new ArrayList<>();
        for(String name : genreNames) {
            List<Music> list = musics.get(name);
            Collections.sort(list, (m1, m2) -> {
                if (m1.playCount == m2.playCount) {
                    return Integer.compare(m1.number, m2.number);
                }
                return Integer.compare(m2.playCount, m1.playCount);
            });
            
            if (list.size() == 1) {
                answer.add(list.get(0).number);
            } else {
                answer.add(list.get(0).number);
                answer.add(list.get(1).number);
            }
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
    
    public String toString() {
        return genre + " " + number + " " + playCount;
    }
}