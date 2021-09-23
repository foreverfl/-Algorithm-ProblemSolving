package JUNGOL;

import java.util.Scanner;

/*정수를 입력받아 첫 줄에 입력 받은 숫자를 출력하고 둘째 줄에 음수이면 “minus” 라고 출력하는 프로그램을 작성하시오.
 * 입력 예: -5
 * 출력 예: -5
          minus
 */
public class _528 {
	public static void main(String[] main) {
		Scanner scanner = new Scanner(System.in);
		int inputScanner = scanner.nextInt();
		scanner.close();
		
		if (inputScanner < 0 ) {
			System.out.println(inputScanner);
			System.out.println("minus");
		} else {
			System.out.println(inputScanner);
		}
	}
}
