package BOJ;

public class Copied_BOJ_04673_SelfNumber {

	public static void main(String[] args) {
		boolean[] check = new boolean[10001];

		for (int i = 1; i < 10001; i++) {
			int n = Not_Self_Number(i);

			if (n < 10001) { // A number over 10000 is needless.
				check[n] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			if (!check[i]) { // Output when the index is 'false'.
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int Not_Self_Number(int a) {
		String str = Integer.toString(a); // changing to String
		String arr[] = str.split(""); 
		int sum = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Integer.parseInt((arr[i]));
		}
		result = a + sum;
		return result;
	}

}
