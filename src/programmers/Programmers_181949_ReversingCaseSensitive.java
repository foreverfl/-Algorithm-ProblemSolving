package programmers;

import java.util.Scanner;

public class Programmers_181949_ReversingCaseSensitive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        sc.close();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char currentChar = a.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                ans.append(Character.toLowerCase(currentChar));
            } else {
                ans.append(Character.toUpperCase(currentChar));
            }
        }

        System.out.println(ans.toString());
    }
}
