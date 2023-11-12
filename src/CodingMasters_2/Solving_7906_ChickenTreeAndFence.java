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

        List<Coord> sortByX = new ArrayList<>(coords);
        List<Coord> sortByY = new ArrayList<>(coords);

        Collections.sort(sortByX, Comparator.comparingInt(o -> o.x));
        Collections.sort(sortByY, Comparator.comparingInt(o -> o.y));

        int[] ans = new int[5];
        for (int i = 0; i < 5; i++) {
            int size = N - i;
            ans[i] = Math.min(calcMinLength(sortByX, size, true), calcMinLength(sortByY, size, false));
        }

        for (int element : ans) {
            System.out.println(element);
        }

    }

    public static int calcMinLength(List<Coord> sortedCoords, int size, boolean isSortByX) {

        int minRes = Integer.MAX_VALUE;
        for (int i = 0; i <= sortedCoords.size() - size; i++) {
            List<Coord> subList = sortedCoords.subList(i, i + size);
            minRes = Math.min(minRes, calcLength(subList, isSortByX));
        }
        return minRes;
    }

    public static int calcLength(List<Coord> coords, boolean isSortByX) {
        if (coords.isEmpty()) {
            return 0;
        }

        int min_x = coords.get(0).x;
        int max_x = coords.get(coords.size() - 1).x;
        int min_y = coords.get(0).y;
        int max_y = coords.get(coords.size() - 1).y;

        for (int i = 0; i < coords.size(); i++) {
            if (isSortByX) { // x축으로 정렬된 경우
                min_y = Math.min(min_y, coords.get(i).y);
                max_y = Math.max(max_y, coords.get(i).y);
            } else { // y축으로 정렬된 경우
                min_x = Math.min(min_x, coords.get(i).x);
                max_x = Math.max(max_x, coords.get(i).x);
            }
        }

        return (max_x - min_x + 2) * 2 + (max_y - min_y + 2) * 2;
    }
}
