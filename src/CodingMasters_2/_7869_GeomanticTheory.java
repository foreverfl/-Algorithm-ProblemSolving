package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7869_GeomanticTheory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char current = map[i][j]; // 시작점

                // 끝점 체크
                for (int endX = i; endX < N; endX++) {
                    for (int endY = j; endY < M; endY++) {
                        if (checkRectangle(map, i, j, endX, endY, current)) {
                            int area = (endX - i + 1) * (endY - j + 1);
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    public static boolean checkRectangle(char[][] map, int startX, int startY, int endX, int endY, char target) {
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (map[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}
