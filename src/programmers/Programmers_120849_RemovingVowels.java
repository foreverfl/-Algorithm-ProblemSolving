package programmers;

public class Programmers_120849_RemovingVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String solution(String my_string) {
        String answer = my_string.replaceAll("a|e|i|o|u", "");        
        return answer;
    }

}
