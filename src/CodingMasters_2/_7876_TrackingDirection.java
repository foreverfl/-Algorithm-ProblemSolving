package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7876_TrackingDirection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] coord = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            coord[i][0] = Integer.parseInt(input[0]);
            coord[i][1] = Integer.parseInt(input[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int diff_x = coord[i][1] - coord[i - 1][1];
            int diff_y = coord[i][0] - coord[i - 1][0];
            int dist = (diff_x == 0) ? Math.abs(diff_y) : Math.abs(diff_x);

            if (diff_x > 0) { // 동쪽
                sb.append("2 " + dist).append('\n');
            } else if (diff_x < 0) { // 서쪽
                sb.append("4 " + dist).append('\n');
            } else if (diff_y > 0) { // 북쪽
                sb.append("1 " + dist).append('\n');
            } else if (diff_y < 0) { // 남쪽
                sb.append("3 " + dist).append('\n');
            }
        }

        System.out.println(sb.toString().trim());
    }
}
