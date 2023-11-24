package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solving_7897_WalkingTrail {

    public static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 북, 동, 남, 서
    public static Set<String> uniquePaths = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        backtrack(0, 0, 0, N, new HashSet<>(), "");
        System.out.println(uniquePaths.size());
    }

    public static void backtrack(int x, int y, int direction, int stepsRemaining, Set<String> visited, String path) {
        if (stepsRemaining == 0) {
            uniquePaths.add(path);
            return;
        }

        String pos = x + "," + y;
        visited.add(pos);

        // 좌회전
        int leftDir = (direction + 3) % 4; // 왼쪽으로 회전
        int nx = x + DIRECTIONS[leftDir][0];
        int ny = y + DIRECTIONS[leftDir][1];
        String newPosLeft = nx + "," + ny;
        if (!visited.contains(newPosLeft)) {
            backtrack(nx, ny, leftDir, stepsRemaining - 1, new HashSet<>(visited), path + "L");
        }

        // 우회전
        int rightDir = (direction + 1) % 4; // 오른쪽으로 회전
        nx = x + DIRECTIONS[rightDir][0];
        ny = y + DIRECTIONS[rightDir][1];
        String newPosRight = nx + "," + ny;
        if (!visited.contains(newPosRight)) {
            backtrack(nx, ny, rightDir, stepsRemaining - 1, new HashSet<>(visited), path + "R");
        }
    }
}