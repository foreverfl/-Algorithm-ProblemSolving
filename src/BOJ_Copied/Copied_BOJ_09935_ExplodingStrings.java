package BOJ_Copied;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Copied_BOJ_09935_ExplodingStrings {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			if (stack.size() >= bomb.length()) {
				boolean flag = true;
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						flag = false;
						break;                                            
					}
				}
				if (flag) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : stack) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}
}

// reference: https://velog.io/@yeoj1n/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-9935%EB%B2%88-%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%8F%AD%EB%B0%9C