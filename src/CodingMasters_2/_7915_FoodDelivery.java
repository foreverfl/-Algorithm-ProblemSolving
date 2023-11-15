package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _7915_FoodDelivery {

    public static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<int[]> houses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            houses.add(new int[] { x, y });
        }

        combination(houses, new ArrayList<>(), K, 0);
        System.out.println(minDistance);
    }

    public static void combination(List<int[]> houses, List<int[]> selected, int K, int start) {
        if (selected.size() == K) {
            permute(selected, 0);
            return;
        }

        for (int i = start; i < houses.size(); i++) {
            selected.add(houses.get(i));
            combination(houses, selected, K, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static void permute(List<int[]> selected, int l) {
        if (l == selected.size() - 1) {
            int distance = calcDist(selected);
            minDistance = Math.min(minDistance, distance);
        } else {
            for (int i = l; i < selected.size(); i++) {
                Collections.swap(selected, l, i);
                permute(selected, l + 1);
                Collections.swap(selected, l, i);
            }
        }
    }

    public static int calcDist(List<int[]> selected) {
        int totalDistance = 0;
        int[] start = { 1, 1 };

        totalDistance += distance(start, selected.get(0)); // 식당에서 첫 번째 집까지의 거리

        // 각 집 사이의 거리
        for (int i = 0; i < selected.size() - 1; i++) {
            totalDistance += distance(selected.get(i), selected.get(i + 1));
        }

        // 마지막 집에서 식당까지의 거리
        totalDistance += distance(selected.get(selected.size() - 1), start);

        return totalDistance;
    }

    public static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}
