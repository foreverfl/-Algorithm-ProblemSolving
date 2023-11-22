package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solving_7914_MakingTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> sticks = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sticks.add(Integer.parseInt(input[i]));
        }

        Collections.sort(sticks);

        // 전체 막대기를 다 사용하는 경우
        if (arePossibleSticks(sticks)) {
            System.out.println(N);
            return;
        }

        int removeCnt = 1;
        loop: while (true) {

            List<int[]> pairs = generatePairs(removeCnt); // 제거할 양 끝의 막대 개수
            for (int[] pair : pairs) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(sticks);

                // 앞쪽에서 막대 제거
                while (pair[0]-- > 0) {
                    tmp.remove(0);
                }

                // 뒤쪽에서 막대 제거
                while (pair[1]-- > 0) {
                    tmp.remove(tmp.size() - 1);
                }

                if (arePossibleSticks(tmp))
                    break loop;
            }
        }

        System.out.println(N - removeCnt);
    }

    public static List<int[]> generatePairs(int N) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            pairs.add(new int[] { i, N - i });
        }

        return pairs;
    }

    public static boolean arePossibleSticks(List<Integer> sticks) {
        int N = sticks.size();
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (!isTriangle(sticks.get(i), sticks.get(j), sticks.get(k))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

}
