package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01193_FindingFractions {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int countingDiagonalLine = 1, accumulatedBeforeLine = 0;

		while (true) {
			if (num <= accumulatedBeforeLine + countingDiagonalLine) {
				if (countingDiagonalLine % 2 == 1) { // the number of line is an odd number.
					System.out.print((countingDiagonalLine - (num - accumulatedBeforeLine - 1)) + "/"
							+ (num - accumulatedBeforeLine));
					break;
				} else { // The number of line is an even number, so the location of denominator and
							// numerator is exchanged.
					System.out.print((num - accumulatedBeforeLine) + "/"
							+ (countingDiagonalLine - (num - accumulatedBeforeLine - 1)));
					break;
				}

			} else {
				accumulatedBeforeLine += countingDiagonalLine;
				countingDiagonalLine++;
			}
		}
	}
}
