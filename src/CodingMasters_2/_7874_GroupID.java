package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _7874_GroupID {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 노드 초기화
        boolean[] visited = new boolean[N + 1];
        @SuppressWarnings("unchecked")
        List<Integer>[] nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            nodes[u].add(v);
            nodes[v].add(u);
        }

        Map<Integer, Integer> groupSize = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int size = dfs(i, nodes, visited);
                groupSize.put(i, size);
            }
        }

        int largestGroupId = -1;
        int largestGroupSize = -1;

        for (Map.Entry<Integer, Integer> entry : groupSize.entrySet()) {
            int groupId = entry.getKey();
            int groupSizeValue = entry.getValue();

            if (groupSizeValue > largestGroupSize ||
                    (groupSizeValue == largestGroupSize && groupId < largestGroupId)) {
                largestGroupId = groupId;
                largestGroupSize = groupSizeValue;
            }
        }

        System.out.println(largestGroupId);
    }

    public static int dfs(int cur, List<Integer>[] nodes, boolean[] visited) {
        visited[cur] = true;
        int count = 1;

        for (int next : nodes[cur]) {
            if (!visited[next]) {
                count += dfs(next, nodes, visited);
            }
        }

        return count;
    }
}
