package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7930_LaunchingStore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);

        long res = 0;
        for (int i = R; i >= L; i--) {
            int start = L;
            int end = i - L;
            int cnt = end - start + 1;
            if (cnt < 0)
                break;
            res += cnt;

        }

        System.out.println(res);
    }
}
