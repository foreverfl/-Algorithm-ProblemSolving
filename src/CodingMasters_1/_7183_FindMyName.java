package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7183_FindMyName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        @SuppressWarnings("unused")
        int N = Integer.parseInt(input[0]);
        String name = input[1];
        String[] names = br.readLine().split(" ");

        int ans = 0;
        for (String str : names) {
            ans++;
            if (str.equals(name)) {
                break;
            }
        }
        System.out.println(ans);

    }
}
