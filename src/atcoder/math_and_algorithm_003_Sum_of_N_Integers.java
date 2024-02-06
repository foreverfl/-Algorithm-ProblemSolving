package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class math_and_algorithm_003_Sum_of_N_Integers {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }
}
