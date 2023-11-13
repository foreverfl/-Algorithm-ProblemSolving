package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7889_OneDimensionalIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] map = br.readLine().toCharArray();

        char[] map_min = Arrays.copyOf(map, map.length);
        char[] map_max = Arrays.copyOf(map, map.length);
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 'x') {
                // 최솟값
                if (i > 0 && map[i - 1] == 'g') {
                    map_min[i] = 'g';
                } else {
                    map_min[i] = 'o';
                }

                // 최댓값
                char prevChar = (i > 0) ? map[i - 1] : 'o';
                map_max[i] = (prevChar == 'o') ? 'g' : 'o';

                int j = i + 1;
                while (j < map.length && map[j] == 'x') {
                    map_max[j] = (map_max[j - 1] == 'g') ? 'o' : 'g';
                    j++;
                }

                i = j - 1;
            }
        }

        int min = 0;
        int max = 0;

        System.out.println(Arrays.toString(map_max));

        boolean isIsalnd = false;
        for (int i = 0; i < map.length; i++) {
            if (map_min[i] == 'g' && !isIsalnd) {
                isIsalnd = true;
            }

            if (map_min[i] == 'o' && isIsalnd) {
                isIsalnd = false;
                min++;
            }
        }

        isIsalnd = false;
        for (int i = 0; i < map.length; i++) {
            if (map_max[i] == 'g' && !isIsalnd) {
                isIsalnd = true;
            }

            if (map_max[i] == 'o' && isIsalnd) {
                isIsalnd = false;
                max++;
            }
        }

        System.out.println(min);
        System.out.println(max);
    }
}
