package JUNGOL;

import java.util.Scanner;

/*������ �Է¹޾� ù �ٿ� �Է� ���� ���ڸ� ����ϰ� ��° �ٿ� �����̸� ��minus�� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է� ��: -5
 * ��� ��: -5
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
