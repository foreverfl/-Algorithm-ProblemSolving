package JUNGOL;

import java.util.Scanner;

/*1�ݺ��� 6�ݱ����� ��������� ������ �� �� ���� �� ��ȣ�� �Է¹޾� �� �� ��������� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �ݺ� ��������� �ʱⰪ���� 1�ݺ��� ���ʷ� 85.6 79.5 83.1 80.0 78.2 75.0���� �ʱ�ȭ�ϰ� 
 * ����� �Ҽ� �� ��° �ڸ����� �ݿø��Ͽ� �Ҽ� ù°�ڸ����� �Ѵ�.
 * �Է� ��: 1 3
 * ��� ��: 168.7
 */
public class _559 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int class1 = scanner.nextInt();
		int class2 = scanner.nextInt();
		scanner.close();
		
		double score[] = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
		double score1 = score[class1-1];
		double score2 = score[class2-1]; // An array starts from array[0]
		
		double sum = score1 + score2;
		
		
		System.out.printf("%.1f", sum);

	}

}
