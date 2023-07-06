package programmers_Copied;

import java.util.Collections;
import java.util.LinkedList;

public class Copied_Programmers_42891_EatingShowLive {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 5));
    }

    public static class Food {
        int num, time;
        
        public Food(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static int solution(int[] food_times, long k) {
        LinkedList<Food> list = new LinkedList<>();
        int len = food_times.length;
        for(int i = 0; i < len; i++) {
            list.add(new Food(i + 1, food_times[i]));
        }

        Collections.sort(list, (o1, o2) -> o1.time - o2.time);
        
        int current_time = 0;
        int idx = 0;
        for(Food food : list) {
            long diff = food.time - current_time; // 현재 음식을 먹는데 필요한 시간 - 현재 시간
            if(diff != 0) {
                long spend = diff * len; // 현재 음식을 섭취하는 시간
                if(spend <= k) {
                    k -= spend;
                    current_time = food.time;
                } else {
                    k %= len;
                    list.subList(idx, food_times.length).sort((o1, o2) -> o1.num - o2.num);
                    return list.get(idx + (int) k).num;
                }
            }
            idx++;
            len--;
        }
        return -1;
    }
    
}

// reference: https://moonsbeen.tistory.com/371