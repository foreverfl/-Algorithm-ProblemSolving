package JUNGOL;

import java.util.Scanner;

/* 10개의 문자를 입력받아서 첫 번째 네 번째 일곱 번째 입력받은 문자를 차례로 출력하는 프로그램을 작성하시오.
 * 입력 예: A B C D E F G H I J
 * 출력 예: A D G
 */

public class _557 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char arr[] = new char[10];
				
		for (int i=0; i<arr.length; i++) {
			arr[i] = scanner.next().charAt(0); 
		}
		scanner.close();
		/* 'scanner.nextline' returns all strings input before pressing [Enter].
		 * 'scanner.next' returns all strings input before blank(entering [space]).
		 */
		
		System.out.println(arr[0] + " " + arr[3] + " " + arr[6]);

	}

}