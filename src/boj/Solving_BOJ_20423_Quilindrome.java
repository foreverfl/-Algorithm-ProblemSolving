package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solving_BOJ_20423_Quilindrome {

	private static List<String> now = new ArrayList<>();
	private static List<String> nxt = new ArrayList<>();
	private static String ans = "-1";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		if (isQuilindrome(str)) {
			ans = str;
			System.out.println(ans);
			return;
		}

		now.add(str);
		for (int i = 0; i < str.length(); i++) {
			addChar();

			for (int j = 0; j < now.size(); j++) {
				if (isQuilindrome(now.get(j))) {
					ans = now.get(j);
					System.out.println(ans);
					return;
				}
			}
			
		}

		System.out.println(ans);
	}

	// 한 글자씩 더해서 리스트에 넣는다.
	private static void addChar() {
		char[] arr = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9' };
		for (int i = 0; i < now.size(); i++) {
			for (int j = 0; j < arr.length; j++) {
				nxt.add(now.get(i) + arr[j]);
			}
		}
		
		now.clear();
		now.addAll(nxt);
		nxt.clear();

	}

	private static boolean isQuilindrome(String str) {
		boolean ans = true;
		if (str.length() % 2 == 0) {
			for (int i = 0; i < str.length() / 2; i++) {
				if (!isContrast(str.charAt(i), str.charAt(str.length() - 1 - i))) {
					return false;
				}
			}
		} else {
			for (int i = 0; i < str.length() / 2; i++) {
				if (!isContrast(str.charAt(i), str.charAt(str.length() - 1 - i))) {
					return false;
				}
			}

			if (!isContrast(str.charAt(str.length() / 2 + 1))) {
				return false;
			}
		}

		return ans;

	}

	private static boolean isContrast(char a) {
		char[] possibleArray = new char[] { 'A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y', 'i', 'l', 'm', 'n',
				'o', 'u', 'v', 'w', 'x', '0', '1', '8' };

		for (int i = 0; i < possibleArray.length; i++) {
			if (a == possibleArray[i])
				return true;
		}

		return false;
	}

	public static boolean isContrast(char a, char b) {
		// 대문자
		if (a == 'A' && b == 'A')
			return true;
		else if (a == 'E' && b == '3')
			return true;
		else if (a == 'H' && b == 'H')
			return true;
		else if (a == 'I' && b == 'I')
			return true;
		else if (a == 'M' && b == 'M')
			return true;
		else if (a == 'O' && b == 'O')
			return true;
		else if (a == 'S' && b == '2')
			return true;
		else if (a == 'T' && b == 'T')
			return true;
		else if (a == 'U' && b == 'U')
			return true;
		else if (a == 'V' && b == 'V')
			return true;
		else if (a == 'W' && b == 'W')
			return true;
		else if (a == 'X' && b == 'X')
			return true;
		else if (a == 'Y' && b == 'Y')
			return true;
		else if (a == 'Z' && b == '5')
			return true;

		// 소문자
		else if (a == 'b' && b == 'd')
			return true;
		else if (a == 'd' && b == 'b')
			return true;
		else if (a == 'i' && b == 'i')
			return true;
		else if (a == 'l' && b == 'l')
			return true;
		else if (a == 'm' && b == 'm')
			return true;
		else if (a == 'n' && b == 'n')
			return true;
		else if (a == 'o' && b == 'o')
			return true;
		else if (a == 'p' && b == 'q')
			return true;
		else if (a == 'q' && b == 'p')
			return true;
		else if (a == 'r' && b == '7')
			return true;
		else if (a == 'u' && b == 'u')
			return true;
		else if (a == 'v' && b == 'v')
			return true;
		else if (a == 'w' && b == 'w')
			return true;
		else if (a == 'x' && b == 'x')
			return true;

		// 숫자
		else if (a == '0' && b == '0')
			return true;
		else if (a == '1' && b == '1')
			return true;
		else if (a == '2' && b == 'S')
			return true;
		else if (a == '3' && b == 'E')
			return true;
		else if (a == '5' && b == 'Z')
			return true;
		else if (a == '7' && b == 'r')
			return true;
		else if (a == '8' && b == '8')
			return true;

		return false;
	}

}
