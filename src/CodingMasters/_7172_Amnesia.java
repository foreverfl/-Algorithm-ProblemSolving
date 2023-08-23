package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7172_Amnesia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int res = 0;
        int cnt = 0;
        while (true) {
            res += numbers[0];
            cnt++;

            if (res >= numbers[2])
                break;

            res -= numbers[1];

        }

        System.out.println(cnt);

    }
}
