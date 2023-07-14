package programmers;

public class Programmers_181906_isPrefix {
    public static int solution(String my_string, String is_prefix) {
        if (my_string.startsWith(is_prefix)) {
            return 1;
        } else {
            return 0;
        }
    }
}
