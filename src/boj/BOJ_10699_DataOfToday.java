package boj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BOJ_10699_DataOfToday {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		String result = simpledateformat.format(date);
		
		System.out.println(result);

	}

}
