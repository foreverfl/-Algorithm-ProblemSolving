package JUNGOL;

/* ���� 2���� �Է¹޾Ƽ� ù ��° ������ 100�� �������� �����ϰ� �� ��° ���� 10���� ���� �������� ������ �� �� ���� ���ʷ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
�Է�: 20 35
���: 120 5
*/
import java.util.Scanner;

public class _519 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt(); 
		int b = scanner.nextInt();
		scanner.close();
		
		System.out.print(a + 100 + "\t");
		System.out.print(b % 10);
	}
}
