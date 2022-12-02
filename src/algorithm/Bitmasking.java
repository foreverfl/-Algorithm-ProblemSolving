package algorithm;

public class Bitmasking {

	public static void main(String... args) {
		System.out.println(1 << 9);
		System.out.println(Integer.toBinaryString(1 << 9));

		for (int c = 0; c < 1 << 9; c++) {
			System.out.println(String.format("%10s", Integer.toBinaryString(c)).replace(" ", "0"));
			System.out.println("==================");
			for (int x = 0; x < 10; x++) {
				System.out.print(String.format("%10s", Integer.toBinaryString(1 << x)).replace(" ", "0"));
				System.out.println(": " + ((c & (1 << x)) != 0));
			}
			System.out.println("==================");
		}

	}
}
