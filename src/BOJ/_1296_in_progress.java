package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _1296_in_progress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String man = sc.nextLine();
		String countAsString = sc.nextLine();
		int count = Integer.parseInt(countAsString);
		String womenArr[] = new String[count];
		int checkArr[] = new int[count];
	

		for (int i = 0; i < womenArr.length; i++) {
			womenArr[i] = sc.nextLine();
			String manArr[] = man.split("");
			String womanArr[] = womenArr[i].split("");
			
			int compareArrLength = manArr.length + womanArr.length; // 결과 배열 총 길이
			String compareArr [] = new String[compareArrLength]; // 결과 배열
			System.arraycopy(manArr, 0, compareArr, 0, manArr.length); 
			System.arraycopy(womanArr, 0, compareArr, manArr.length, womanArr.length); // 배열 합치기
			Arrays.toString(compareArr);
			/* public String toString()
			 * This object (which is already a string!) is itself returned.
			 */
			List<String> lCkeck = Arrays.asList(compareArr); // 정확히 알아보기..ㅠㅠ
			int lCount = Collections.frequency(lCkeck, "L");
			List<String> oCkeck = Arrays.asList(compareArr);
			int oCount = Collections.frequency(oCkeck, "O");
			List<String> vCkeck = Arrays.asList(compareArr);
			int vCount = Collections.frequency(vCkeck, "V");
			List<String> eCkeck = Arrays.asList(compareArr);
			int eCount = Collections.frequency(eCkeck, "E");
			
			int check = ((lCount+oCount)*(lCount+vCount)*(lCount+eCount)*(oCount+vCount)*(oCount+eCount)*(vCount+eCount)) % 100;			
			checkArr[i] = check;
						
			lCount = 0;
			oCount = 0;
			vCount = 0;
			eCount = 0;
			
			System.out.print(checkArr[i] + " ");
		}

	}

}
