package BOJ_incomplete;

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

		// - ���Ŀ� +�� ���̱�
		for (int i = 0; i < list.size() - 2; i++) { // �������� + �Ⱥ��� �׷��� list.size()-2
			if (list.get(i).equals("-")) {
				list.add(i + 2, "+");
			}
		}

		// ���ӵ� ��ȣ ó��
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).equals("+") && list.get(i + 1).equals("-")) {
				list.remove(i);
			}
			if (list.get(i).equals("+") && list.get(i + 1).equals("+")) {
				list.remove(i);
			}
		}

		// 0ó��
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