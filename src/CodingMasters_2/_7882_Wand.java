package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _7882_Wand {

    public static final Map<Integer, Integer> memo = new HashMap<>();
    public static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int res = findMin(num);
        System.out.println(res == INF ? -1 : res);
    }

    public static int findMin(int n) {
        if (n == 1) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = INF;

        if (n % 2 == 0) {
            result = Math.min(result, findMin(n / 2) + 1);
        }
        if (n % 3 == 0) {
            result = Math.min(result, findMin((n / 3) * 2) + 1);
        }
        if (n % 5 == 0) {
            result = Math.min(result, findMin((n / 5) * 4) + 1);
        }

        memo.put(n, result);

        return result;
    }

}
