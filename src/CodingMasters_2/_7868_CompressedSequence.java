package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class _7868_CompressedSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] firstLine = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = firstLine[0];
        int M = firstLine[1];

        int[] input = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int res = -1;
        for (int i = 10; i <= 62; i++) {
            int fileSize = N - 1;
            for (int num : input) {
                fileSize += getLengthInBase(num, i);
            }

            if (fileSize <= M) {
                res = i;
                break;
            }
        }

        System.out.println(res);

    }

    public static int getLengthInBase(int number, int radix) {
        if (number == 0)
            return 1;

        int length = 0;
        while (number > 0) {
            length++;
            number /= radix;
        }

        return length;
    }

}
