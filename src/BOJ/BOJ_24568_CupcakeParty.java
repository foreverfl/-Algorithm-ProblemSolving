package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24568_CupcakeParty {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		int total = R * 8 + S * 3;
		int result = total - 28;
		
		System.out.println(result);
	}

}
