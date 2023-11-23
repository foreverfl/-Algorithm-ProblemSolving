package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solving_7914_MakingTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sticks = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sticks[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(sticks);

        int result = findMaxSticks(sticks);

        System.out.println(result);

    }

    public static int findMaxSticks(int[] sticks) {
        int left = 0;
        int right = sticks.length - 1;

        while (left < right - 1) {
            if (sticks[left] + sticks[left + 1] > sticks[right]) {
                return right - left + 1;
            } else {
                left++;
            }
        }

        return 0;
    }
}