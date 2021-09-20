package BOJ;

import java.util.Scanner;

public class BOJ_02908_FILIP {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String First = sc.next();
		String Second = sc.next();

		String Arr_First[] = First.split("");
		String Arr_First_Reverse[] = new String[First.length()];
		String Arr_Second[] = Second.split("");
		String Arr_Second_Reverse[] = new String[Second.length()];

		for (int i = Arr_First.length - 1, j = 0; i >= 0; i--, j++) {
			Arr_First_Reverse[j] = Arr_First[i];
		}
		for (int i = Arr_Second.length - 1, j = 0; i >= 0; i--, j++) {
			Arr_Second_Reverse[j] = Arr_Second[i];
		}

		First = String.join("", Arr_First_Reverse);
		Second = String.join("", Arr_Second_Reverse);

		System.out.println(Math.max(Integer.parseInt(First), Integer.parseInt(Second)));
	}

}
