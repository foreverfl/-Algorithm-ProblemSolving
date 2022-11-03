package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_05635_Birthday {

	static List<BirthDay> list = new ArrayList<>();

	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			String name = st.nextToken();
			String dd = st.nextToken();
			String mm = st.nextToken();
			String yyyy = st.nextToken();
			String tmp = yyyy + "-" + mm + "-" + dd;
			Date date = sdformat.parse(tmp);

			list.add(new BirthDay(name, date));
		}

		Collections.sort(list);

		System.out.println(list.get(list.size() - 1).name);
		System.out.println(list.get(0).name);
	}

}

class BirthDay implements Comparable<BirthDay> {
	String name;
	Date birthday;

	BirthDay(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	@Override
	public int compareTo(BirthDay o) {
		return this.birthday.compareTo(o.birthday);
	}
}
