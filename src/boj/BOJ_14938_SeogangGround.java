package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14938_SeogangGround {
    public static final int INF = 9999999; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");
        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(input[i - 1]);
        }

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int l = Integer.parseInt(input[2]);
            graph[a][b] = l;
            graph[b][a] = l;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int maxItems = 0;
        for (int i = 1; i <= n; i++) {
            int itemsCollected = items[i]; // 현재 지역에 있는 아이템
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] <= m) { // 수색 범위 내에 있는 지역이라면
                    itemsCollected += items[j]; 
                }
            }
            maxItems = Math.max(maxItems, itemsCollected);
        }

        System.out.println(maxItems);
    }
}
