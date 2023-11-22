package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7946_OptimumLocation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int minDistanceSum = Integer.MAX_VALUE;
        int optimalX = 0, optimalY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int distanceSum = 0;

                // 모든 주택과의 거리 합을 계산
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (map[x][y] == 'H') {
                            distanceSum += Math.abs(i - x) + Math.abs(j - y);
                        }
                    }
                }

                if (distanceSum < minDistanceSum) {
                    minDistanceSum = distanceSum;
                    optimalX = i;
                    optimalY = j;
                }
            }
        }

        System.out.println((optimalX + 1) + " " + (optimalY + 1));
    }
}
