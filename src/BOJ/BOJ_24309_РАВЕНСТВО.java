package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_24309_¬²¬¡¬£¬¦¬¯¬³¬´¬£¬° {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger a = new BigInteger(br.readLine());
		BigInteger b = new BigInteger(br.readLine());
		BigInteger c = new BigInteger(br.readLine());

		BigInteger result = (b.subtract(c)).divide(a);
		System.out.println(result);
	}

}
