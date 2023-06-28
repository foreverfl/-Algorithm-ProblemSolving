package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15650_NAndM_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        backtrack(N, M, 1, new ArrayList<>());

    }

    private static void backtrack(int N, int M, int start, List<Integer> list) {
        if (list.size() == M) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int i = start; i <= N; i++) {
            list.add(i);
            backtrack(N, M, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
