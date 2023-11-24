package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7927_PattyPattyBurger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 패티의 최소 장수
        int K = Integer.parseInt(input[1]); // 버거의 최대 개수
        int M = Integer.parseInt(br.readLine()); // 버거의 종류

        int[][] burgers = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            burgers[i][0] = Integer.parseInt(line[0]); // 패티 장수
            burgers[i][1] = Integer.parseInt(line[1]); // 가격
        }

        int Q = Integer.parseInt(br.readLine());

        System.out.println(findMinCost(N, K, M, burgers, Q));

    }

    public static int findMinCost(int N, int K, int M, int[][] burgers, int Q) {
        // 1장당 가격으로 정렬
        Arrays.sort(burgers, (a, b) -> Double.compare((double) a[1] / a[0], (double) b[1] / b[0]));

        int totalPatties = 0;
        int totalCost = 0;
        int burgerCount = 0;

        // 최소 하나의 햄버거 추가
        totalPatties += burgers[0][0];
        totalCost += burgers[0][1];
        burgerCount++;

        // 추가 패티 또는 햄버거를 추가하는 것 중 더 저렴한 옵션 선택
        while (totalPatties < N && burgerCount < K) {
            if ((double) burgers[burgerCount][1] / burgers[burgerCount][0] < (double) Q) {
                totalPatties += burgers[0][0];
                totalCost += burgers[0][1];
                burgerCount++;
            } else {
                totalPatties++;
                totalCost += Q;
            }
        }

        // 패티가 모자란 경우, 추가 패티 구매
        if (totalPatties < N) {
            totalCost += (N - totalPatties) * Q;
        }

        return totalCost;
    }
}
