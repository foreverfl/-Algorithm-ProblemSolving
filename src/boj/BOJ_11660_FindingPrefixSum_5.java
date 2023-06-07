package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_FindingPrefixSum_5 {
    private static int[][] generatePrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int topSum = (i > 0) ? prefixSum[i - 1][j] : 0;
                int leftSum = (j > 0) ? prefixSum[i][j - 1] : 0;
                int diagonalSum = (i > 0 && j > 0) ? prefixSum[i - 1][j - 1] : 0;

                prefixSum[i][j] = matrix[i][j] + topSum + leftSum - diagonalSum;
            }
        }

        return prefixSum;
    }

    private static int getSubmatrixSum(int[][] prefixSum, int row1, int col1, int row2, int col2) {
        int sumTotal = prefixSum[row2][col2];

        if (row1 > 0) {
            sumTotal -= prefixSum[row1 - 1][col2];
        }

        if (col1 > 0) {
            sumTotal -= prefixSum[row2][col1 - 1];
        }

        if (row1 > 0 && col1 > 0) {
            sumTotal += prefixSum[row1 - 1][col1 - 1];
        }

        return sumTotal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] table = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSum = generatePrefixSum(table);

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(getSubmatrixSum(prefixSum, x1 - 1, y1 - 1, x2 - 1, y2 - 1));
        }

        br.close();
    }
}
