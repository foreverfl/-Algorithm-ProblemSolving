package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class abc340_B_Append {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            String[] query = br.readLine().split(" ");
            int type = Integer.parseInt(query[0]);
            int num = Integer.parseInt(query[1]);

            if (type == 1) {
                list.add(num);
            } else {
                sb.append(list.get(list.size() - num)).append('\n');
            }

        }

        System.out.println(sb.toString().trim());
    }
}
