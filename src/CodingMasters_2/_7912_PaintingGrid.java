package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7912_PaintingGrid {
    public static int N, M, result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[][] grid = new int[N][M];

        paintGrid(grid, 0, 0);
        System.out.println(result);
    }

    public static void paintGrid(int[][] grid, int row, int col) {
        if (row == N) {
            result++;
            return;
        }

        int nextRow = col == M - 1 ? row + 1 : row;
        int nextCol = col == M - 1 ? 0 : col + 1;

        for (int color = 1; color <= 3; color++) {
            if (isSafe(grid, row, col, color)) {
                grid[row][col] = color;
                paintGrid(grid, nextRow, nextCol);
                grid[row][col] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] grid, int row, int col, int color) {
        if (row > 0 && grid[row - 1][col] == color) // 상단 확인
            return false;
        if (col > 0 && grid[row][col - 1] == color) // 좌측 확인
            return false;

        return true;
    }
}
