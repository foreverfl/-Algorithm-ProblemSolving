package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7934_RestoringString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        List<String> tmp_1 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]); // 첫 값은 무조건 들어감

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - '0' != 0 && arr[i - 1] - '0' == 0) {
                tmp_1.add(sb.toString());
                sb.setLength(0);
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]);
            }
        }

        if (sb.length() > 0) {
            tmp_1.add(sb.toString());
        }

        // System.out.println(tmp_1);

        List<String> tmp_2 = new ArrayList<>();
        for (int i = 0; i < tmp_1.size(); i++) {
            String[] str = processCharacter(tmp_1.get(i)).split(" ");
            for (int j = 0; j < str.length; j++) {
                tmp_2.add(str[j]);
            }

        }

        // System.out.println(tmp_2);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tmp_2.size(); i++) {
            res.append(toAlphabet(tmp_2.get(i)));
        }

        System.out.println(res.toString());
    }

    public static String processCharacter(String num) {
        StringBuilder result = new StringBuilder();

        // 마지막 0 제거
        if (num.endsWith("0")) {
            num = num.substring(0, num.length() - 1);

            for (int i = 0; i < num.length() - 2; i++) {
                result.append(num.charAt(i)).append(" ");
            }

            if (num.length() >= 2) {
                int lastNumber = Integer.parseInt(num.substring(num.length() - 2));
                result.append(lastNumber).append(" ");
            }
        } else {
            for (int i = 0; i < num.length(); i++) {
                result.append(num.charAt(i)).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static char toAlphabet(String number) {
        return (char) ('a' + Integer.parseInt(number) - 1);
    }

}
