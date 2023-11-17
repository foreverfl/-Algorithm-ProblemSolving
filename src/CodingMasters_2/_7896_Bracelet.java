package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7896_Bracelet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int len = first.length();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                int new_idx = (i + j) % len;
                sb.append(first.charAt(new_idx));
            }
            list.add(sb.toString());
            sb.setLength(0);
        }

        System.out.println(list.contains(second) ? "YES" : "NO");
    }
}
