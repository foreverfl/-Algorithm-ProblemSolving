package BOJ_complete;

import java.util.Scanner;

public class BOJ_01075_Division {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();
		int ToSecond = 0; // It starts from '00'.
		String FromThird = "";
		String str = Integer.toString(N);
		String arr[] = str.split("");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 2) {
				FromThird += arr[i];
			}

		}
		while (true) {
			if ((Integer.parseInt(FromThird) * 100 + ToSecond) % F != 0) {
				ToSecond = ToSecond + 1;
			}

			if ((Integer.parseInt(FromThird) * 100 + ToSecond) % F == 0) {
				break;
			}
		}
		System.out.printf("%02d", ToSecond);
	}

}
