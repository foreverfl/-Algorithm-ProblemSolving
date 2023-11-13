package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7893_Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isPossible = false;
        for (int startRow = 0; startRow < rows; startRow++) {
            for (int endRow = startRow; endRow < rows; endRow++) {
                for (int startCol = 0; startCol < cols; startCol++) {
                    for (int endCol = startCol; endCol < cols; endCol++) {

                        // 합 체크하기
                        int sum = 0;
                        for (int i = startRow; i <= endRow; i++) {
                            for (int j = startCol; j <= endCol; j++) {
                                sum += matrix[i][j];
                            }
                        }
                        if (sum == K) {
                            isPossible = true;
                        }
                    }
                }
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }
}
