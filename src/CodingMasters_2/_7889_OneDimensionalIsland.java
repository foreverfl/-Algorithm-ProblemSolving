package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7889_OneDimensionalIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] map = br.readLine().toCharArray();
        int len = map.length;

        char[] map_min = Arrays.copyOf(map, map.length);
        char[] map_max = Arrays.copyOf(map, map.length);

        // 최솟값
        for (int i = 0; i < map.length; i++) {
            // 앞/뒤의 값이 g면 연속적인 x를 g로 바꿈
            if (map[i] == 'x') {
                if ((i > 0 && map[i - 1] == 'g') || (i < len - 1 && map[i + 1] == 'g')) {
                    map_min[i] = 'g';

                    int j = i + 1;
                    while (j < map.length && map[j] == 'x') {
                        map_min[j] = 'g';
                        j++;
                    }

                    i = j - 1;
                } else {
                    map_min[i] = 'o';
                }
            }
        }

        // 최댓값
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 'x') {
                // 앞의 값이 o이면 gogogo... 처리
                // 앞의 값이 g이면 ogogog... 처리
                char prevChar = (i > 0) ? map[i - 1] : 'o';
                map_max[i] = (prevChar == 'o') ? 'g' : 'o';

                int j = i + 1;
                while (j < map.length && map[j] == 'x') {
                    map_max[j] = (map_max[j - 1] == 'g') ? 'o' : 'g';
                    j++;
                }

                i = j - 1; // 원상 복구
            }
        }

        // System.out.println(Arrays.toString(map_min));
        // System.out.println(Arrays.toString(map_max));

        System.out.println(countIsland(map_min));
        System.out.println(countIsland(map_max));
    }

    public static int countIsland(char[] map) {
        int count = 0;
        boolean inIsland = false;

        for (int i = 0; i < map.length; i++) {
            if (map[i] == 'g') {
                if (!inIsland) {
                    count++;
                    inIsland = true;
                }
            } else {
                inIsland = false;
            }
        }

        return count;
    }
}
