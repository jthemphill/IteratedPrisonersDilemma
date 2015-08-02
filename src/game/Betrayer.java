package game;
/**
 * Always betrays its opponent
 * @author lphemphill
 * 7/31/15
 */
public class Betrayer implements Player{

	
	public Betrayer(){}
	public int play() {
		return 1;
	}

	public String name() {
		return "Betrayer";
	}

	public void receiveLastResponse(int opponentAnswer) {}
	public void newOpponent(){};

}
