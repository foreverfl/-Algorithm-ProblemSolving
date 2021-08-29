package jungol;
/* 1야드(yd)는 91.44cm이고 1인치(in)는 2.54cm이다. 
 * 2.1야드와 10.5인치를 각각 cm로 변환하여 다음 형식에 맞추어 소수 첫째자리까지 출력하시오.​
 */
public class _513 {
	public static void main(String[] args) {
		double yd = 91.44;
		double in = 2.54;
		System.out.printf(" 2.1yd = %.1fcm \n", 2.1*yd);
		System.out.printf("10.5in =  %.1fcm \n", 10.5*in);
	}
}
