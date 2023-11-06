package CodingMasters_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7163_FindPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String[] parts = text.split(" ");

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            ans.append(parts[i] + " ");
            if (parts[i].equals("c")) {
                break;
            }
        }
        System.out.println(ans.toString().trim());

    }
}
