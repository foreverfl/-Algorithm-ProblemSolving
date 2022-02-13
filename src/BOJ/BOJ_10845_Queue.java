package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BOJ_10845_Queue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int last = 0; // the last value of the queue
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			String arr[] = str.split(" ");
			String arrcheck[] = Arrays.copyOf(arr, 2);

			if (str.equals("push " + arrcheck[1])) {
				queue.add(Integer.parseInt(arrcheck[1]));
				if (arr.length == 2) {
					last = Integer.parseInt(arr[1]); // saving the last value
				}

			} else if (arrcheck[0].equals("pop")) {
				try {
					System.out.println(queue.remove());
				} catch (NoSuchElementException e) {
					System.out.println(-1);
				}

			} else if (arrcheck[0].equals("size")) {
				System.out.println(queue.size());

			} else if (arrcheck[0].equals("empty")) {
				if (queue.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}

			} else if (arrcheck[0].equals("front")) {

				if (queue.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}

			} else if (arrcheck[0].equals("back")) {
				if (queue.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(last);
				}

			}
		}

	}

}
