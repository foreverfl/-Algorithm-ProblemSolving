package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solving_BOJ_17896_MeowFactor2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] meow_4 = { "meow" };
		String[] meow_3 = { "meo.{1}", "me.{1}w", "m.{1}ow", ".{1}eow", "meo.{1}w", "me.{1}ow", "m.{1}eow", "emow", "moew",
				"mewo" };
		String[] meow_2 = { "me.{2}", "m.{2}w", ".{2}ow", "m.{1}o.{1}", ".{1}e.{1}w", ".{1}eo.{1}", "emwo" };
		String[] meow_1 = { "m.{3}", ".{1}e.{2}", ".{2}o.{1}", ".{3}w" };

		Pattern pattern;
		Matcher matcher;
		for (int i = 0; i < meow_4.length; i++) {
			pattern = Pattern.compile(meow_4[i]);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				System.out.println("0");
				return;
			}
		}

		for (int i = 0; i < meow_3.length; i++) {
			pattern = Pattern.compile(meow_3[i]);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				System.out.println("1");
				return;
			}
		}

		for (int i = 0; i < meow_2.length; i++) {
			pattern = Pattern.compile(meow_2[i]);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				System.out.println("2");
				return;
			}
		}

		for (int i = 0; i < meow_1.length; i++) {
			pattern = Pattern.compile(meow_1[i]);
			matcher = pattern.matcher(str);

			if (matcher.find()) {
				System.out.println("3");
				return;
			}
		}

		System.out.println("4");

	}

}
