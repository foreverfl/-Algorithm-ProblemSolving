package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Copied_BOJ_04828_XML {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		while ((str = br.readLine()) != null) {
			CompletableFuture.completedFuture(str).thenApply(xml::removeEscape).thenApply(xml::removeHex)
					.thenApply(xml::checkAndRemoveTag).thenApply(xml::checkPlainText).thenApply(s -> "valid")
					.exceptionally(s -> "invalid").thenAccept(System.out::println);
		}

		br.close();

	}
}

class xml {
	public static String removeEscape(String str) {
		return str.replaceAll("(&amp;)|(&lt;)|(&gt;)", "");
	}

	public static String removeHex(String str) {
		Matcher m = Pattern.compile("&x[a-fA-F0-9]+;").matcher(str);

		while (m.find()) {
			String hex = m.group().replaceAll("[&x;]", "");

			if (hex.length() % 2 != 0) {
				throw new RuntimeException();
			}
		}

		return str.replaceAll("&x[a-fA-F0-9]+;", "");
	}

	public static String checkAndRemoveTag(String str) {
		Stack<String> context = new Stack<>();

		str = str.replaceAll("<[a-z0-9]+/>", "0"); // The '0' prevents the '<a><<a/>/a>' to be valid.
		Matcher m = Pattern.compile("</?[a-z0-9]+>").matcher(str);

		while (m.find()) {
			String rawTag = m.group();

			if (rawTag.startsWith("</")) {
				String openTag = context.pop().replaceAll("[<>/]", "");
				String closeTag = rawTag.replaceAll("[<>/]", "");

				if (openTag.equals(closeTag) == false) {
					throw new RuntimeException();
				}
			} else {
				context.push(rawTag);
			}
		}

		if (context.isEmpty() == false) {
			throw new RuntimeException();
		}

		return str.replaceAll("</?[a-z0-9]+>", "");
	}

	public static String checkPlainText(String str) {
		if ("invalid".equals(str) || str.contains("<") || str.contains(">") || str.contains("&")) {
			throw new RuntimeException();
		}

		for (char ch : str.toCharArray()) {
			if (ch < 32 || 127 < ch) {
				throw new RuntimeException();
			}
		}

		return str;
	}
}

// reference: https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=occidere&logNo=221355611607
