package programmers;

public class Programmers_120883_LoginSuccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String[] id_pw, String[][] db) {
		for (int i = 0; i < db.length; i++) {
			if (db[i][0].equals(id_pw[0]) && db[i][1].equals(id_pw[1])) {
				return "login";
			}
		}

		for (int i = 0; i < db.length; i++) {
			if (db[i][0].equals(id_pw[0]) && !(db[i][1].equals(id_pw[1]))) {
				return "wrong pw";
			}
		}

		return "fail";
	}

}
