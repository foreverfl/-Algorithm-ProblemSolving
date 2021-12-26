package BOJ;

import java.util.Scanner;

public class BOJ_02941_LJESNJAK {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int count = 0;

		while (true) {
			if (input.contains("c=")) {
				input = input.replaceFirst("c=", " ");
				count++;
			} else if (input.contains("c-")) {
				input = input.replaceFirst("c-", " ");
				count++;
			} else if (input.contains("dz=")) {
				input = input.replaceFirst("dz=", " ");
				count++;
			} else if (input.contains("d-")) {
				input = input.replaceFirst("d-", " ");
				count++;
			} else if (input.contains("lj")) {
				input = input.replaceFirst("lj", " ");
				count++;
			} else if (input.contains("nj")) {
				input = input.replaceFirst("nj", " ");
				count++;
			} else if (input.contains("s=")) {
				input = input.replaceFirst("s=", " ");
				count++;
			} else if (input.contains("z=")) {
				input = input.replaceFirst("z=", " ");
				count++;
			}

			if (!(input.contains("c=") || input.contains("c-") || input.contains("dz=") || input.contains("d-")
					|| input.contains("lj") || input.contains("nj") || input.contains("s=") || input.contains("z="))) {
				break;
			}
		}

		if (input.contains(" "))
			input = input.replaceAll(" ", "");

		int temp = input.length();
		count += temp;

		System.out.println(count);

	}

}
