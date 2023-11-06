package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _7865_Chattering {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int K = input[1];

        String str = br.readLine();

        String res = str.chars()
                .mapToObj(c -> String.valueOf((char) c).repeat(K))
                .collect(Collectors.joining());

        System.out.println(res);
    }
}
