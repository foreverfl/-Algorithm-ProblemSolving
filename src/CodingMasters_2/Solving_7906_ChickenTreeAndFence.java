package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solving_7906_ChickenTreeAndFence {

    static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Coord> coords = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            coords.add(new Coord(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        // X와 Y를 동시에 고려한 정렬
        Collections.sort(coords, new Comparator<Coord>() {
            @Override
            public int compare(Coord c1, Coord c2) {
                if (c1.x != c2.x) {
                    return Integer.compare(c1.x, c2.x);
                } else {
                    return Integer.compare(c1.y, c2.y);
                }
            }
        });

        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            int size = N - i;
            ans[i] = calcMinLength(coords, size);
        }

        for (int cost : ans) {
            System.out.println(cost);
        }

    }

    public static int calcMinLength(List<Coord> coords, int size) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= coords.size() - size; i++) {
            List<Coord> subList = coords.subList(i, i + size);
            minCost = Math.min(minCost, calcPerimeter(subList));
        }
        return minCost;
    }

    public static int calcPerimeter(List<Coord> coords) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (Coord coord : coords) {
            minX = Math.min(minX, coord.x);
            maxX = Math.max(maxX, coord.x);
            minY = Math.min(minY, coord.y);
            maxY = Math.max(maxY, coord.y);
        }

        return 2 * (maxX - minX + 1) + 2 * (maxY - minY + 1) + 4;
    }
}
