package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7947_MaintainanceWork {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도로 크기
        int K = Integer.parseInt(br.readLine()); // 내구도
        int M = Integer.parseInt(br.readLine()); // 일수

        int[][] road = new int[N][N];
        StringTokenizer st;
        int tiles = 0;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;

            // 비가 내림
            for (int i = x; i <= z; i++) {
                for (int j = y; j <= w; j++) {
                    road[i][j]++;
                    if (road[i][j] >= K) {
                        road[i][j] = 0;
                        tiles++;
                    }
                }
            }
        }

        System.out.println(tiles);

    }
}
