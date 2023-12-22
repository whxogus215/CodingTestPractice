import java.util.*;

class Solution {
    
    class Food {
        int time;
        int index;
        
        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
    
    Comparator<Food> compTime = new Comparator<>() {
        public int compare(Food a, Food b) {
            return a.time - b.time;
        }
    };
    
    Comparator<Food> compIndex = new Comparator<>() {
        public int compare(Food a, Food b) {
            return a.index - b.index;
        }
    };
    
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        
        List<Food> foods = new ArrayList<>();
        for(int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }
        
        foods.sort(compTime);
        
        int pretime = 0;
        int idx = 0;
        int n = food_times.length;
        
        for (Food f : foods) {
            long diff = f.time - pretime;
            if (diff != 0) {
                if (k < diff * n) {
                    foods.subList(idx, food_times.length).sort(compIndex);
                    k %= n;
                    return foods.get(idx + (int)k).index;
                }
                k -= diff * n;
            }
            pretime = f.time;
            n--;
            idx++;
        }
        
        return -1;
    }
}