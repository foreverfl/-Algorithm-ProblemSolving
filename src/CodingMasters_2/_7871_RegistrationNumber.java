package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _7871_RegistrationNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String part1 = br.readLine();
        String part3 = br.readLine();
        String R = br.readLine();

        List<Integer> PossibleNums = new ArrayList<>();

        for (int i = 11; i < 86; i++) {
            String part2 = Integer.toString(i);
            String registrationNum = part1 + part2 + part3;
            if (isValid(registrationNum, Integer.parseInt(R))) {
                PossibleNums.add(i);
            }
        }

        System.out.println(refer(PossibleNums));

    }

    public static boolean isValid(String registrationNum, int V) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < registrationNum.length(); i++) {
            int digit = Character.getNumericValue(registrationNum.charAt(i));

            if (i % 2 == 0) { // 인덱스가 홀수 자리
                sumOdd += digit;
            } else { // 인덱스가 짝수 자리
                sumEven += digit;
            }
        }

        int R = (2 * sumEven + sumOdd) % 10;
        int checkDigit = (10 - R) % 10;
        return checkDigit == V;
    }

    public static String refer(List<Integer> possibleNums) {
        String[] classification = new String[] { "X", "X", "X", "X", "X" };

        for (int i = 0; i < possibleNums.size(); i++) {
            int now = possibleNums.get(i);
            if (now >= 11 && now <= 15) {
                classification[0] = "O";
            } else if (now >= 21 && now <= 22) {
                classification[1] = "O";
            } else if (now >= 31 && now <= 51) {
                classification[2] = "O";
            } else if (now >= 81 && now <= 86) {
                classification[3] = "O";
            } else if (now == 71) {
                classification[4] = "O";
            }
        }

        return String.join("", classification);
    }
}
