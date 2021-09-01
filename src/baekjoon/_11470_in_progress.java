package baekjoon;

import java.util.Scanner;

public class _11470_in_progress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		if (str.contains("+")) { // [String].contains 문자열에 특정 문자 포함 여부..
			char[] arr = str.toCharArray(); // 문자열을 배열로 변환
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '-') {
				
				}
			}

		} else {
			System.out.println(str);
		}

	}

	// 입력값 제한
	public boolean checkStr(String textInput) {

		char chrInput;

		for (int i = 0; i < textInput.length(); i++) {
			chrInput = textInput.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
			if (chrInput >= 0x30 && chrInput <= 0x39 && chrInput == 0x2B && chrInput == 0x2D) {
				// 숫자, +, -로 값 제한
				return true;
			}
		}
		return false;
	}
}
