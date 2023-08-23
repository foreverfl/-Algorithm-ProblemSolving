package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _7184_FindElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        IntStream.range(0, arr.length)
                .filter(i -> arr[i] == numbers[1])
                .findFirst()
                .ifPresentOrElse(index -> System.out.println(index + 1), () -> System.out.println(-1));
    }
}
