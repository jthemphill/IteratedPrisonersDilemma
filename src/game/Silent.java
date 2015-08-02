package game;
/**
 * Always is silent against its opponent
 * @author lphemphill
 * 7/31/15
 */
public class Silent implements Player{

	
	public Silent(){}
	public int play() {
		return 0;
	}

	public String name() {
		return "Silent";
	}

	public void receiveLastResponse(int opponentAnswer) {}
	public void newOpponent(){};

}
