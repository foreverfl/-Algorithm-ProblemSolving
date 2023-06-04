package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_01406_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            leftStack.push(ch);
        }
        
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            
            if (command.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (command.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (command.equals("B")) {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (command.startsWith("P")) {
                char ch = command.charAt(2);
                leftStack.push(ch);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!leftStack.isEmpty()) {
            result.append(leftStack.pop());
        }
        result.reverse();
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }
       
        System.out.println(result.toString());
    }
}
