package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class BOJ_10828_Stack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			String arr[] = str.split(" ");
			String arrcheck[] = Arrays.copyOf(arr, 2);

			if (str.equals("push " + arrcheck[1])) {
				stack.push(Integer.parseInt(arrcheck[1]));

			} else if (arrcheck[0].equals("pop")) {
				try {
					System.out.println(stack.pop());
				} catch (EmptyStackException e) {
					System.out.println(-1);
				}

			} else if (arrcheck[0].equals("size")) {
				System.out.println(stack.size());

			} else if (arrcheck[0].equals("empty")) {
				if (stack.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}

			} else if (arrcheck[0].equals("top")) {
				try {
					System.out.println(stack.peek());
				} catch (EmptyStackException e) {
					System.out.println(-1);
				}

			}
		}
	}

}
