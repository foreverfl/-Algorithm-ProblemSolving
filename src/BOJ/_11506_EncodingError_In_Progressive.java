package BOJ;

import java.io.UnsupportedEncodingException;

public class _11506_EncodingError_In_Progressive {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "efbfbd";
		byte[] xxx = a.getBytes("UTF-8");

		for (byte x : xxx) {
			System.out.println(Integer.toHexString(x & 0xFF));
		}
	}
}
