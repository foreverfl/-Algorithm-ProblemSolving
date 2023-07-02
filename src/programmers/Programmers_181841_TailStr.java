package programmers;

public class Programmers_181841_TailStr {
    public static String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();

        for (String str : str_list) {
            if (!str.contains(ex)) {
                answer.append(str);
            }
        }

        return answer.toString();
    }
}
