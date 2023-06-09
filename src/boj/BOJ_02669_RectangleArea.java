package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02669_RectangleArea {
    public static void main(String[] args) throws IOException {
        int[][] myMap = new int[100][100];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int k = 0; k < 4; k++) {
            String[] inputs = reader.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    myMap[i][j] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (myMap[i][j] == 1) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
