package programmers;

import java.util.Arrays;

public class Programmers_42577_PhoneNumberList {
	public static void main(String args[]) {
		String[] phone_book_1 = { "119", "97674223", "1195524421" };
		boolean res_1 = solution(phone_book_1);
		System.out.println(res_1);

		String[] phone_book_2 = { "123", "456", "789" };
		boolean res_2 = solution(phone_book_2);
		System.out.println(res_2);

		String[] phone_book_3 = { "12", "123", "1235", "567", "88" };
		boolean res_3 = solution(phone_book_3);
		System.out.println(res_3);
	}

	public static boolean solution(String[] phone_book) {

		Arrays.sort(phone_book);

		for (int i = 1; i < phone_book.length; i++) {
			String now = phone_book[i - 1];
			
			if(now.length() > phone_book[i].length())
				continue;
			
			String check = phone_book[i].substring(0, now.length());

			if (check.equals(now))
				return false;

		}
		return true;
	}
}
