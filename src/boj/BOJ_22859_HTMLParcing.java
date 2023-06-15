package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ_22859_HTMLParcing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();

        String pattern = "<div title=\"(.*?)\">(.*?)</div>";
        Pattern divPattern = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher divMatcher = divPattern.matcher(html);

        while (divMatcher.find()) {
            String title = divMatcher.group(1);
            String innerHTML = divMatcher.group(2);
            String innerPattern = "<p>(.*?)</p>";
            Pattern pPattern = Pattern.compile(innerPattern);
            Matcher pMatcher = pPattern.matcher(innerHTML);

            System.out.println("title : " + title);
            while (pMatcher.find()) {
                String innerMatch = pMatcher.group(1);
                String res = innerMatch.replaceAll("<.*?>", "");  // 태그 삭제
                res = res.replaceAll("\\s{2,}", " ");  // 연속 공백 처리
                res = res.trim();  // 양끝 공백 처리
                System.out.println(res);
            }
        }
    }
}
