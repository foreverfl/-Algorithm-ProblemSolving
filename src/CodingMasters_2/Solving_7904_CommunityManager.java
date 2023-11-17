package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solving_7904_CommunityManager {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");

        Set<String> first_set = mixString(first, N);
        Set<String> second_set = mixString(second, N);

        int cnt = 0;
        for (String str : first_set) {
            if (second_set.contains(str)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static Set<String> mixString(String[] arr, int N) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String[] tmp = arr.clone();
                String tmp_element = tmp[i];
                tmp[i] = tmp[j];
                tmp[j] = tmp_element;
                set.add(String.join(" ", tmp));
            }
        }

        return set;
    }

}
