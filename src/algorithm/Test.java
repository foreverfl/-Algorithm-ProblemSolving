package algorithm;

public class Test {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i & 1);
			System.out.println(" " + Integer.toBinaryString(i & 1));
		}
	}

}
