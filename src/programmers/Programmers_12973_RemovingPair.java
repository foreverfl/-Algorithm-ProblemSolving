package programmers;

import java.util.Stack;

public class Programmers_12973_RemovingPair {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

}
