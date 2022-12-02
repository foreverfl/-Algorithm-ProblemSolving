package programmers;

public class Programmers_12919_FindingKim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String[] seoul) {
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim"))
				return "김서방은 " + i + "에 있다";
		}
		return null;
	}

}
