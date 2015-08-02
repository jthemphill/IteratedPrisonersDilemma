package game;
/**
 * Randomly decides to stay silent or to betray its opponent
 * @author lphemphill
 * 7/31/15
 */
public class Random implements Player{
	
	public Random(){}
	public int play() {
		return (int) Math.floor(Math.random()*2);
	}

	public String name() {
		return "Random";
	}

	public void receiveLastResponse(int opponentAnswer) {}
	public void newOpponent(){};

}
