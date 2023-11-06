package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _7173_Limbo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        @SuppressWarnings("unused")
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = IntStream.range(0, numbers.length).filter(i -> numbers[i] <= 160).findFirst()
                .orElse(-1);

        if (index != -1) {
            System.out.println("I " + numbers[index]);
        } else {
            System.out.println("P");
        }
    }
}
