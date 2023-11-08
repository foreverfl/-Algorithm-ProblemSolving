package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class _7963_Doubles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] players = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        // 정렬하기
        Arrays.sort(players);

        long min = Long.MAX_VALUE;
        // 슬라이딩 윈도우 마다 가능한 경우의 수를 계산
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        long team1 = players[i] * players[l];
                        long team2 = players[j] * players[k];
                        long diff = Math.abs(team1 - team2);
                        min = Math.min(diff, min);
                    }
                }
            }
        }

        System.out.println(min);

    }
}
