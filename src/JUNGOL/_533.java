package JUNGOL;

import java.util.Scanner;

/*
 * ���ڴ� 'M' ���ڴ� 'F'�� ��Ÿ����� �ϰ� 18�� �̻��� �����̶�� ����.
 * ����('M', 'F')�� ���̸� �Է¹޾� "MAN"(���γ���), "WOMAN"(���ο���), "BOY"(�̼��Ⳳ��), "GIRL"(�̼��⿩��)�� �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է� ��: F 15
 * ��� ��: GIRL
*/
public class _533 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0); // char c = str.charAt(0); �� it outputs a first character in a string.
		int age = sc.nextInt(); 	  // System.out.println(c + " " + age);
		sc.close();
		
		if (c == 'M') {
			if (age >= 18) {
				System.out.println("MAN");
			} else {
				System.out.println("BOY");
			}

		} else if (c == 'F') {
			if (age >= 18) {
				System.out.println("WOMAN");
			} else {
				System.out.println("GIRL");
			}

		}
	}
}
