package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11470_EasyArithmetic {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();

		String str = sc.next();
		String arr[] = str.split("");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		for (int i = 0; i < list.size() - 2; i++) {
			if (list.get(i).equals("-")) { // - 이후의 숫자에 +값 붙이기
				list.add(i + 2, "+");
			}
		}

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).equals("+") && list.get(i + 1).equals("-")) {
				list.remove(i);
			}
			if (list.get(i).equals("+") && list.get(i + 1).equals("+")) {
				list.remove(i);
			}
		}

		System.out.print(String.join("", list));

	}
}