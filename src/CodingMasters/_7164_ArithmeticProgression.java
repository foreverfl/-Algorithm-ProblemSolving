package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7164_ArithmeticProgression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = numbers[0];
        int r = numbers[1];
        int n = numbers[2];
        System.out.println(a + r * (n - 1));
    }
}
