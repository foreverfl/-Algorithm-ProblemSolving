package BOJ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solving_BOJ_11470_EasyArithmetic {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();

		String str = sc.next();
		String arr[] = str.split("");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		// - 이후에 +값 붙이기
		for (int i = 0; i < list.size() - 2; i++) { // 마지막에 + 안붙임 그래서 list.size()-2
			if (list.get(i).equals("-")) {
				list.add(i + 2, "+");
			}
		}

		// 연속된 부호 처리
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).equals("+") && list.get(i + 1).equals("-")) {
				list.remove(i);
			}
			if (list.get(i).equals("+") && list.get(i + 1).equals("+")) {
				list.remove(i);
			}
		}

		// 0처리
		for (int i = 0; i < list.size(); i++) {
			while (true) {
				if (list.get(i).equals("+") && list.get(i + 1).equals("0")) {
					list.set(i + 2, "+0");
					if (list.get(i).equals("+") || list.get(i).equals("-")) {
						break;
					}
				}
			}

		}

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.print(String.join("", list));

	}
}