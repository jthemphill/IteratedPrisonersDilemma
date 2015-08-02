package game;

/**
 * Passes a secret code in case its opponent is a flunky and listens
 * for the opponent's code. If our opponent is a flunky, we betray
 * forever. Otherwise, we play Friedman style.
 *
 * @author jthemphill
 * 8/2/15
 */
public class Mastermind implements Player {
	static final int[] SECRETCODE = { 1, 1, 0, 0, 1 };

	private int round;
	private boolean betrayed;
	private boolean matches;

	public Mastermind() {}

	public int play() {
		if (matches && round < SECRETCODE.length) {
			return SECRETCODE[round++];
		} else if (matches) {
			return 1;
		} else {
			return betrayed ? 1 : 0;
		}
	}

	public String name() {
		return "Mastermind";
	}

	public void receiveLastResponse(int opponentAnswer) {
		if (round < SECRETCODE.length) {
			matches = matches && (SECRETCODE[round] == opponentAnswer);
		} else {
			betrayed = betrayed && (opponentAnswer == 1);
		}

		++round;
	}

	public void newOpponent(){
		round = 0;
		betrayed = false;
		matches = true;
	};
}
