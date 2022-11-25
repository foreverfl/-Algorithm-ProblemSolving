package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_06634_DigitalDisplay {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String time = br.readLine();

			if (time.equals("end")) {
				sb.append("end");
				break;
			}

			String[] digit = makeToDigit(time);

			for (int i = 0; i < digit.length; i++) {
				sb.append(digit[i]).append('\n');
			}

			int repeat = 2;
			while (repeat-- > 0) {
				sb.append('\n');
			}
		}

		System.out.println(sb.toString());

	}

	private static String[] makeToDigit(String time) {
		String[] digit = new String[7];

		for (int i = 0; i < 7; i++) {
			digit[i] = "";
		}

		for (int i = 0; i < time.length(); i++) {
			char now = time.charAt(i);

			// 숫자 만들기
			if (now == '0') {

				digit[0] += "+---+";
				digit[1] += "|   |";
				digit[2] += "|   |";
				digit[3] += "+   +";
				digit[4] += "|   |";
				digit[5] += "|   |";
				digit[6] += "+---+";

			} else if (now == '1') {

				digit[0] += "    +";
				digit[1] += "    |";
				digit[2] += "    |";
				digit[3] += "    +";
				digit[4] += "    |";
				digit[5] += "    |";
				digit[6] += "    +";

			} else if (now == '2') {

				digit[0] += "+---+";
				digit[1] += "    |";
				digit[2] += "    |";
				digit[3] += "+---+";
				digit[4] += "|    ";
				digit[5] += "|    ";
				digit[6] += "+---+";

			} else if (now == '3') {

				digit[0] += "+---+";
				digit[1] += "    |";
				digit[2] += "    |";
				digit[3] += "+---+";
				digit[4] += "    |";
				digit[5] += "    |";
				digit[6] += "+---+";

			} else if (now == '4') {

				digit[0] += "+   +";
				digit[1] += "|   |";
				digit[2] += "|   |";
				digit[3] += "+---+";
				digit[4] += "    |";
				digit[5] += "    |";
				digit[6] += "    +";

			} else if (now == '5') {

				digit[0] += "+---+";
				digit[1] += "|    ";
				digit[2] += "|    ";
				digit[3] += "+---+";
				digit[4] += "    |";
				digit[5] += "    |";
				digit[6] += "+---+";

			} else if (now == '6') {

				digit[0] += "+---+";
				digit[1] += "|    ";
				digit[2] += "|    ";
				digit[3] += "+---+";
				digit[4] += "|   |";
				digit[5] += "|   |";
				digit[6] += "+---+";

			} else if (now == '7') {

				digit[0] += "+---+";
				digit[1] += "    |";
				digit[2] += "    |";
				digit[3] += "    +";
				digit[4] += "    |";
				digit[5] += "    |";
				digit[6] += "    +";

			} else if (now == '8') {

				digit[0] += "+---+";
				digit[1] += "|   |";
				digit[2] += "|   |";
				digit[3] += "+---+";
				digit[4] += "|   |";
				digit[5] += "|   |";
				digit[6] += "+---+";

			} else if (now == '9') {

				digit[0] += "+---+";
				digit[1] += "|   |";
				digit[2] += "|   |";
				digit[3] += "+---+";
				digit[4] += "    |";
				digit[5] += "    |";
				digit[6] += "+---+";

			} else if (now == ':') {
				digit[0] += "     ";
				digit[1] += "     ";
				digit[2] += "  o  ";
				digit[3] += "     ";
				digit[4] += "  o  ";
				digit[5] += "     ";
				digit[6] += "     ";
			}

			// 중간에 빈칸 만들기
			if (i == 1 || i == 2 || i == 4) {

			} else {
				digit[0] += "  ";
				digit[1] += "  ";
				digit[2] += "  ";
				digit[3] += "  ";
				digit[4] += "  ";
				digit[5] += "  ";
				digit[6] += "  ";
			}

		}

		return digit;
	}
}
