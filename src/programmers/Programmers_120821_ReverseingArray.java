package programmers;

public class Programmers_120821_ReverseingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] num_list) {
		int[] arr = new int[num_list.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = num_list[arr.length - 1 - i];
		}

		return arr;
	}

}
