package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7904_CommunityManager {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");

        int diff = 0;
        for (int i = 0; i < N; i++) {
            if (!first[i].equals(second[i])) {
                diff++;
            }
        }
        if (diff == 4) {
            System.out.println(2);
        } else if (diff == 3) {
            System.out.println(3);
        } else {
            System.out.println(0);
        }

    }

}
