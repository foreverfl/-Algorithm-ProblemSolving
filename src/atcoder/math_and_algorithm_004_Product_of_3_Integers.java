package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class math_and_algorithm_004_Product_of_3_Integers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
        System.out.println(res);
    }
}
