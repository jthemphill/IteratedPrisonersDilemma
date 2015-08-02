package game;
/**
 * Starts out by staying silent, but once betrayed against it will always betray
 * @author Originally thought up by James Friedman, written for java by lphemphill
 * 7/31/15
 */
public class Friedman implements Player{

	private boolean betrayed;
	public Friedman(){
		betrayed = false;
	}
	public int play() {
		if(!betrayed){
			return 0;
		}else { return 1; }
	}

	public String name() {
		return "Friedman";
	}

	public void receiveLastResponse(int opponentAnswer) {
		if(opponentAnswer == 1) betrayed = true;
	}
	public void newOpponent(){
		betrayed = false;
	};

}
