package baekjoon;

import java.util.Scanner;

public class _1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		if (a % 3 == 0) {

		} else if (a % 3 == 1) {

		} else { // a%3 == 2

		}

	}

}

class Operation {
	public int a;

	public Operation() {
	}

	public int multipleOf3_0(int a) {
		if (a % 3 == 0) {
			return a / 3;
		} else {
			return a;
		}
	}

	public int multipleOf3_1(int a) {
		if (a % 3 == 1) {
			return a - 1;
		} else {
			return a;
		}
	}
	
	public int multipleOf3_2(int a) {
		if (a % 3 == 1) {
			return a - 1;
		} else {
			return a;
		}
	}
	
	
}
