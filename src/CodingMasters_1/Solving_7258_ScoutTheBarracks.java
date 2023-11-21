package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solving_7258_ScoutTheBarracks {

    public static int N, P;
    public static List<Integer>[] graph;
    public static int[][] memo;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        graph = new ArrayList[N];
        memo = new int[N][2 * P + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(memo[i], -1); // -1로 초기화
        }

        for (int i = 0; i < P; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            graph[from].add(to);
            graph[to].add(from);
        }

        System.out.println(dfs(0, 0) / 2);

    }

    public static int dfs(int current, int count) {
        if (current == 1 && count >= 1) { // 2번 막사에 도착
            return count;
        }

        // 이미 계산된 값이 있으면 반환
        if (memo[current][count] != -1) {
            return memo[current][count];
        }

        int result = 0;
        for (int next : graph[current]) {
            if (next == 1 && count < 1) // 처음에 바로 2번 막사로 가지 않게 함
                continue;

            // 1번과 2번 막사는 재방문 가능, 그 외에는 재방문 불가능
            if (next == 0 || next == 1 || memo[next][count] == -1) {
                result = Math.max(result, dfs(next, count + 1));
            }
        }

        // 결과를 메모이제이션 테이블에 저장
        memo[current][count] = result;
        return result;
    }
}
