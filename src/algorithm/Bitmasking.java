package algorithm;

public class Bitmasking {

	public static void main(String[] args) {
		int a = 9; // 1001 in binary
		int b = 5; // 0101 in binary
		System.out.println("a: " + String.format("%4s", Integer.toBinaryString(a)).replace(' ', '0'));
		System.out.println("b: " + String.format("%4s", Integer.toBinaryString(b)).replace(' ', '0'));
		System.out.println("============================");

		// 비트 AND 연산: 두 비트 모두 1일 때만 1을 반환
		int and = a & b; // 결과: 0001 (1 in decimal)

		// 비트 OR 연산: 두 비트 중 하나라도 1이면 1을 반환
		int or = a | b; // 결과: 1101 (13 in decimal)

		// 비트 XOR 연산: 두 비트가 서로 다를 때 1을 반환
		int xor = a ^ b; // 결과: 1100 (12 in decimal)

		// 비트 NOT 연산: 모든 비트를 반전
		int not = ~a; // 결과는 a의 비트를 모두 반전한 값

		// 왼쪽 시프트: 모든 비트를 왼쪽으로 이동시킴 (빈자리는 0으로 채움)
		int leftShift = a << 1; // 결과: 10010 (18 in decimal)

		// 오른쪽 시프트: 모든 비트를 오른쪽으로 이동시킴 (빈자리는 원래의 상위 비트로 채움)
		int rightShift = a >> 1; // 결과: 0100 (4 in decimal)

		// 출력
		System.out.println("AND: " + String.format("%4s", Integer.toBinaryString(and)).replace(' ', '0'));
		System.out.println("OR: " + String.format("%4s", Integer.toBinaryString(or)).replace(' ', '0'));
		System.out.println("XOR: " + String.format("%4s", Integer.toBinaryString(xor)).replace(' ', '0'));
		System.out.println("NOT: " + String.format("%4s", Integer.toBinaryString(not)).replace(' ', '0'));
		System.out.println("Left Shift: " + String.format("%4s", Integer.toBinaryString(leftShift)).replace(' ', '0'));
		System.out
				.println("Right Shift: " + String.format("%4s", Integer.toBinaryString(rightShift)).replace(' ', '0'));
		System.out.println(not);
	}
}
