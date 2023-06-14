package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01780_TheNumberOfPaper {
    static int cntMinus1 = 0;
    static int cnt0 = 0;
    static int cnt1 = 0;

    public static void divideAndConquer(int[][] arr, int row, int col, int size) {
        boolean isSame = true;
        int firstColor = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != firstColor) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            if (firstColor == -1) {
                cntMinus1++;
            } else if (firstColor == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
        } else {
            int dividedSize = size / 3;
            divideAndConquer(arr, row, col, dividedSize);
            divideAndConquer(arr, row, col + dividedSize, dividedSize);
            divideAndConquer(arr, row, col + dividedSize * 2, dividedSize);
            divideAndConquer(arr, row + dividedSize, col, dividedSize);
            divideAndConquer(arr, row + dividedSize, col + dividedSize, dividedSize);
            divideAndConquer(arr, row + dividedSize, col + dividedSize * 2, dividedSize);
            divideAndConquer(arr, row + dividedSize * 2, col, dividedSize);
            divideAndConquer(arr, row + dividedSize * 2, col + dividedSize, dividedSize);
            divideAndConquer(arr, row + dividedSize * 2, col + dividedSize * 2, dividedSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }

        divideAndConquer(paper, 0, 0, N);

        System.out.println(cntMinus1);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }
}
