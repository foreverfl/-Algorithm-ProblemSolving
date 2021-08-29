package jungol;

import java.util.Scanner;

/*키를 입력받아 출력하는 프로그램을 작성하라.
(입력할때 "height = " 문장을 먼저 출력하고 키를 입력 받아야 합니다.)
입력예 : height = 170
출력예 : Your height is 170cm.


*/
public class _514 {

	public static void main(String[] args) {
		System.out.print("height = ");		
		
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		scanner.close();
		
		System.out.println("Your height is " + height + "cm.");
		

	}

}
