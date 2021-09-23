package BOJ;

import java.util.Scanner;

public class BOJ_01439_Reverse {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Input = sc.next();
		String Check = "";
		String arr1[] = Input.split("");

		if (arr1[0].equals("0")) { // ù ���� 0�̸� A, 1�̸� B
			Check = "A";
		} else if (arr1[0].equals("1")) {
			Check = "B";
		}

		for (int i = 1; i < arr1.length; i++) { // ���ӵ� 0�� A, ���ӵ� 1�� B
			if (arr1[i - 1].equals("1") && (arr1[i].equals("0"))) { //
				Check += "A";
			} else if (arr1[i - 1].equals("0") && (arr1[i].equals("0"))) {
				continue;
			} else if (arr1[i - 1].equals("0") && (arr1[i].equals("1"))) {
				Check += "B";
			} else if (arr1[i - 1].equals("0") && (arr1[i].equals("0"))) {
				continue;
			}
		}

		String arr2[] = Check.split("");
		int Count_A = 0;
		int Count_B = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i].equals("A")) {
				Count_A++;
			} else if (arr2[i].equals("B")) {
				Count_B++;
			}
		}

		System.out.println(Math.min(Count_A, Count_B));

	}
}
