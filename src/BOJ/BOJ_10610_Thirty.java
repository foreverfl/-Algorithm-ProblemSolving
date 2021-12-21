package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_10610_Thirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String input_arr[] = input.split("");
        int input_arr_int[] = new int[input.length()];

        for (int i = 0; i < input_arr.length; i++) {
            input_arr_int[i] = Integer.parseInt(input_arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < input_arr_int.length; i++) {
            sum += input_arr_int[i];
        }

        if (!Arrays.asList(input_arr).contains("0")) {
            System.out.println("-1");
        } else if (!(sum % 3 == 0)) {
            System.out.println("-1");
        } else {
            Arrays.sort(input_arr, Collections.reverseOrder());
            System.out.println(String.join("", input_arr));
        }

    }
}