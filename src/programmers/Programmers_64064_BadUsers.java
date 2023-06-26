package programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers_64064_BadUsers {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"}));
        System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "*rodo", "******", "******"}));
    }

    public static int solution(String[] user_id, String[] banned_id) {

        Set<Set<String>> result = new HashSet<>(); 
        backtrack(user_id, banned_id, new HashSet<>(), result, 0);
        return result.size(); 

    }

    public static void backtrack(String[] user_id, String[] banned_id, Set<String> selected, Set<Set<String>> result, int index) {
        if (index == banned_id.length) {
            if (selected.size() == banned_id.length) {
                result.add(new HashSet<>(selected)); // 가능한 경우의 수를 저장
            }
            return;
        }

        String banned = banned_id[index];

        for (String user : user_id) {
            if (selected.contains(user)) { // 이미 선택된 사용자인 경우
                continue;
            }

            if (isMatch(user, banned)) {
                selected.add(user);
                backtrack(user_id, banned_id, selected, result, index + 1); 
                selected.remove(user);
            }
        }
    }

    public static boolean isMatch(String user, String banned) {
        String regex = banned.replace("*", ".");
        return user.matches(regex);
    }
}
