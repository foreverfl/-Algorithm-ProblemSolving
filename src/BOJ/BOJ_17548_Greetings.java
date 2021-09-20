package BOJ;

import java.util.Scanner;

public class BOJ_17548_Greetings {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String arr[] = str.split("");
		int cnt = 0;
		String e = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("e")) {
				cnt++;
			}
		}
		for (int i = 0; i < cnt * 2; i++) {
			e += "e";
		}

		System.out.println("h" + e + "y");
	}

}
