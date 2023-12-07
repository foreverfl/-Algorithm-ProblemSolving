package programmers;

public class Programmers_12951_JadenCase {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isCapital = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(ch);
                isCapital = true;
            } else if (isCapital) {
                sb.append(Character.toUpperCase(ch));
                isCapital = false;
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}