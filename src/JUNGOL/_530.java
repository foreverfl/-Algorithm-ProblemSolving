package JUNGOL;

import java.util.Scanner;

public class _530 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		sc.close();
		if(age>=20) {
			System.out.println("adult");
		} else {
			System.out.println(20-age + " years later");
		}
	}

}
