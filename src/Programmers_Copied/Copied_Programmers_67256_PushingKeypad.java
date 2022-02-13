package Programmers_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_Programmers_67256_PushingKeypad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[] = new int[11];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		String hand = br.readLine();

		String result = solution(arr, hand);

		System.out.println(result);
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		String answer = "";
		int leftIndex = 10;	 // '*' => 10
		int rightIndex = 12; // '#' => 12

		for(int number : numbers) {
			if(number == 1 || number == 4 || number == 7) {
				sb.append("L");
				leftIndex = number;
			} else if(number == 3 || number == 6 || number == 9) {
				sb.append("R");
				rightIndex = number;
			} else { 
				int leftLength = getLength(leftIndex, number);
				int rightLength = getLength(rightIndex, number);

				if(leftLength > rightLength) {
					sb.append("R");
					rightIndex = number;
				} else if(leftLength < rightLength) {
					sb.append("L");
					leftIndex = number;
				} else {
					if(hand.equals("right")) {
						sb.append("R");
						rightIndex = number;
					} else {
						sb.append("L");
						leftIndex = number;
					}
				}
			}
		}
		
		answer = sb.toString();
		return answer;
	}

	public static int getLength(int index, int number) {

		// In case of the '0' it is replaced by the '11'.
		index = (index == 0) ? 11 : index;	
		number = (number == 0) ? 11 : number;

		int x = (index - 1) / 3;
		int y = (index - 1) % 3;
		int numberX = number / 3;
		int numberY = 1;

		return Math.abs(x-numberX) + Math.abs(y-numberY);
	}

}

// reference: https://zzang9ha.tistory.com/292
