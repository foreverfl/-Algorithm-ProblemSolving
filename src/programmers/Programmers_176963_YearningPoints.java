package programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_176963_YearningPoints {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] ans = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    ans[i] += map.get(photo[i][j]);
                }
            }
        }

        return ans;
    }
}
