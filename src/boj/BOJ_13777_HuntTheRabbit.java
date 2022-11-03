package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_13777_HuntTheRabbit {
	static List<Integer> arraylist = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				break;
			}
			binarySearch(input, 1, 50);

			print();

		}

	}

	static int binarySearch(int key, int low, int high) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			arraylist.add(mid);

			if (key == mid) {
				return mid;
			} else if (key < mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0;
	}

	static void print() {
		int totalElements = arraylist.size();// arrayList�� ����� ������ ���Ѵ�.
		for (int index = 0; index < totalElements; index++) {
			System.out.print(arraylist.get(index) + " ");
		}
		arraylist.clear();
	}
}