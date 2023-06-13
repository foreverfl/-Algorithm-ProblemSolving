package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02630_MakingColoredPaper {
    static int[][] paper;
    static int cnt_0, cnt_1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        cnt_0 = 0;
        cnt_1 = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);

        System.out.println(cnt_0);
        System.out.println(cnt_1);
    }

    public static void divideAndConquer(int row, int col, int size) {
        boolean isSame = true;
        int firstColor = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != firstColor) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            if (firstColor == 0) {
                cnt_0++;
            } else {
                cnt_1++;
            }
        } else {
            int halfSize = size / 2;
            divideAndConquer(row, col, halfSize);
            divideAndConquer(row, col + halfSize, halfSize);
            divideAndConquer(row + halfSize, col, halfSize);
            divideAndConquer(row + halfSize, col + halfSize, halfSize);
        }
    }
}
