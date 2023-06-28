package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15649_NandM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        backtrack(N, M, new ArrayList<>(), new boolean[N + 1]);

    }

    private static void backtrack(int N, int M, List<Integer> list, boolean[] used) {
        if(list.size() == M) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            list.add(i);             
            backtrack(N, M, list, used);            
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
