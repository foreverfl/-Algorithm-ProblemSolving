package jungol;

/*다음과 같이 출력되는 프로그램을 작성하라.
 * 출력 예
 * My height 
 * 170
 * My weight
 * 68.600000
 */

public class _506 {

	public static void main(String[] args) {
		int height = 170;
		double weight = 68.6;
		
		System.out.println("My height");
		System.out.println(height);
		System.out.println("My weight");
		System.out.printf("%.6f", weight);
	

	}

}
