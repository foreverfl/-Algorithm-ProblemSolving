package programmers;

public class Programmers_181843_isSubstring {
    public int solution(String my_string, String target) {
        if (my_string.contains(target))
            return 1;
        else
            return 0;
    }
}
