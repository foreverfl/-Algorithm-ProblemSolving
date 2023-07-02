package programmers;

public class Programmers_181873_CharToUpperCase {
    public static String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (c == alp.charAt(0)) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String result = solution("programmers", "p");
        System.out.println(result);
    }
}
