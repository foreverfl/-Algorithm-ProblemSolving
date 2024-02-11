package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class abc340_C_Divide_and_Divide {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        long money = 0;

        Queue<Double> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            double now = queue.poll();

            if (now > 1) {
                money += now;
                double ceil = Math.ceil(now / 2.0);
                double floor = Math.floor(now / 2.0);
                queue.add(ceil);
                queue.add(floor);
            }
        }

        System.out.println(money);
    }
}
