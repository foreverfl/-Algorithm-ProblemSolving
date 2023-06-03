package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_02493_Tower {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 Stack
        
        for (int i = 0; i < N; i++) {
            // System.out.println(i + ": " + stack);
            // 현재 탑의 높이와 스택의 탑들과 비교하여 레이저 신호를 수신하는 탑 찾기
            while (!stack.isEmpty() && towers[stack.peek()] < towers[i]) {
                stack.pop(); // 이전 탑은 수신할 수 없으므로 스택에서 제거
            }

            if (!stack.isEmpty()) {
                ans[i] = stack.peek() + 1; // 레이저 신호를 수신하는 탑의 인덱스 저장
            }
            
            stack.push(i); // 현재 탑의 인덱스를 스택에 추가
            // System.out.println(Arrays.toString(ans));
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
