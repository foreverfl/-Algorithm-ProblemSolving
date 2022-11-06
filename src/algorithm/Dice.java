package algorithm;

public class Dice {
	private static class DiceExample {
		int up, down, left, right, front, back;

		public DiceExample() {
			up = 1;
			down = 6;
			left = 4;
			right = 3;
			front = 5;
			back = 2;
		}

		private void rollDice(int dir) {
			if (dir == 0)
				toNorth();
			else if (dir == 1)
				toEast();
			else if (dir == 2)
				toSouth();
			else
				toWest();
		}

		private void toEast() {
			int save = up;
			up = left;
			left = down;
			down = right;
			right = save;
		}

		private void toWest() {
			int save = up;
			up = right;
			right = down;
			down = left;
			left = save;
		}

		private void toNorth() {
			int save = up;
			up = front;
			front = down;
			down = back;
			back = save;
		}

		private void toSouth() {
			int save = up;
			up = back;
			back = down;
			down = front;
			front = save;
		}

	}

	private static int reverseDir(int dir) {
		return (dir + 2) % 4;
	}

	private static int getNextDir(int diceBottom, int boardNum, int dir) {
		if (diceBottom > boardNum) { // clockwise
			return (dir + 1) % 4;
		} else if (diceBottom < boardNum) { // counter-clockwise
			return (dir + 3) % 4;
		} else
			return dir;
	}
}
