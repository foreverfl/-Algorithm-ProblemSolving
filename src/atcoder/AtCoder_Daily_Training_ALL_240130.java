package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtCoder_Daily_Training_ALL_240130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println(set.size());
    }
}
