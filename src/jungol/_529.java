package jungol;

import java.util.Scanner;

/* ��������+100-Ű���� �񸸼�ġ �����̶�� ����. Ű�� �����Ը� �ڿ����� �Է¹޾� ù ��° �ٿ� �񸸼�ġ�� ����ϰ�,
  * �񸸼�ġ�� 0���� ũ�� �����ٿ� ��("Obesity")�̶�� �޽����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. (��������� �Ʒ� ��� ���� �����ϼ���.)
  * �Է� ��: 155 60
  * ��� ��: 5
           Obesity
  */
public class _529 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int BMI = weight + 100 - height; 
		sc.close();
		
		System.out.println(BMI);
		if (BMI >= 0 ) {
			System.out.println("Obesity");
		}

	}

}
