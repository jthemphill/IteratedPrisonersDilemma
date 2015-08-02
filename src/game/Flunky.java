package game;

/**
 * Listens for the Mastermind's secret code and send our own code
 * back. If our opponent is the mastermind or another flunky, we
 * hopelessly cooperate. Otherwise, we betray forever.
 *
 * @author jthemphill
 * 8/2/15
 */
public class Flunky implements Player {
	private int number;

	private int round;
	private boolean matches;

	public Flunky(int number) {
		this.number = number;
	}

	public int play() {
		if (matches && round < Mastermind.SECRETCODE.length) {
			return Mastermind.SECRETCODE[round++];
		} else {
			return matches ? 0 : 1;
		}
	}

	public String name() {
		return String.format("Flunky #%d", number);
	}

	public void receiveLastResponse(int opponentAnswer) {
		if (round < Mastermind.SECRETCODE.length) {
			matches = matches && (Mastermind.SECRETCODE[round] == opponentAnswer);
		}

		++round;
	}

	public void newOpponent(){
		round = 0;
		matches = true;
	};
}
