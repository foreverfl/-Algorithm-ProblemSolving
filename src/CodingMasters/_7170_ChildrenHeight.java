package CodingMasters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7170_ChildrenHeight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int average = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum() / 2;

        System.out.println(average);

    }
}
