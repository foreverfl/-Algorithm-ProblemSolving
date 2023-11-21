package CodingMasters_2;

import java.util.HashSet;
import java.util.Set;

public class Solving_7897_WalkingTrail {

    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N, E, S, W

    public static void main(String[] args) {
        int n = 4; // 예시 입력
        System.out.println("Unique paths for N = 4: " + countUniquePaths(n));

        n = 8; // 예시 입력
        System.out.println("Unique paths for N = 8: " + countUniquePaths(n));
    }

    private static int countUniquePaths(int n) {
        return backtrack(0, 0, 0, n, new HashSet<>());
    }

    private static int backtrack(int x, int y, int direction, int stepsRemaining, Set<String> visited) {
        if (stepsRemaining == 0) {
            return 1;
        }

        int paths = 0;
        String pos = x + "," + y;
        visited.add(pos);

        // 좌회전
        int leftDir = (direction + 3) % 4; // 왼쪽으로 회전
        int nx = x + DIRECTIONS[leftDir][0];
        int ny = y + DIRECTIONS[leftDir][1];
        String newPosLeft = nx + "," + ny;
        if (!visited.contains(newPosLeft)) {
            paths += backtrack(nx, ny, leftDir, stepsRemaining - 1, visited);
        }

        // 우회전
        int rightDir = (direction + 1) % 4; // 오른쪽으로 회전
        nx = x + DIRECTIONS[rightDir][0];
        ny = y + DIRECTIONS[rightDir][1];
        String newPosRight = nx + "," + ny;
        if (!visited.contains(newPosRight)) {
            paths += backtrack(nx, ny, rightDir, stepsRemaining - 1, visited);
        }

        visited.remove(pos);
        return paths;
    }
}