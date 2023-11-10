package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solving_7959_KingOfElections {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        int first = arr[0];
        int persuaded = 0;

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort(Map.Entry.comparingByKey());

        for (Map.Entry<Integer, Integer> entry : list) {
            int supporters = entry.getKey();
            int candidates = entry.getValue();

            while (supporters > first && candidates > 0) {
                persuaded++;
                first++;
                candidates--;
            }
        }

        System.out.println(persuaded);
    }
}

// 카운팅 정렬?