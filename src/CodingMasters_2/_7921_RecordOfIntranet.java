package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class _7921_RecordOfIntranet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 네트워크 구성
        Map<Integer, List<Integer>> network = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int hubComputer = M * (i - 1) + 1;
            List<Integer> connectedComputers = new ArrayList<>();
            for (int j = 1; j <= M; j++) {
                int connectedComputer = M * (i - 1) + j;
                if (connectedComputer != hubComputer) { // 허브 컴퓨터 자신은 제외
                    connectedComputers.add(connectedComputer);
                }
            }
            network.put(hubComputer, connectedComputers);
        }

        // for (Map.Entry<Integer, List<Integer>> entry : network.entrySet()) {
        // System.out.println("Computer " + entry.getKey() + " is connected to: " +
        // entry.getValue());
        // }

        int K = Integer.parseInt(br.readLine());
        int[] records = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isValid = true;
        for (int i = 0; i < K - 1; i++) {
            if (!isPossible(network, records[i], records[i + 1])) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? "YES" : "NO");

    }

    public static boolean isPossible(Map<Integer, List<Integer>> network, int now, int nxt) {
        // 중앙 컴퓨터에서는 모든 1차 허브로 이동 가능
        if (now == 0) {
            return network.containsKey(nxt);
        }

        // now가 1차 허브 컴퓨터인 경우
        else if (network.containsKey(now)) {
            return nxt == 0 || network.get(now).contains(nxt);
        }

        // now가 2차 허브 컴퓨터인 경우
        else {
            int parentHub = findParentHub(network, now);
            return parentHub == nxt || network.get(parentHub).contains(nxt);
        }
    }

    private static int findParentHub(Map<Integer, List<Integer>> network, int computer) {
        for (Map.Entry<Integer, List<Integer>> entry : network.entrySet()) {
            if (entry.getValue().contains(computer)) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
