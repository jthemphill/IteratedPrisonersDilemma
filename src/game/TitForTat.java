package game;
/**
 * Begins by staying silent against its opponent, then mimics its last response
 * @author Anatol Rapoport, written for java by lphemphill
 * 7/31/15
 */
public class TitForTat implements Player{

	private int opponentResponse;
	
	public TitForTat(){
		opponentResponse = -1;
	}
	public int play() {
		if(opponentResponse == -1) return 0;
		else return opponentResponse;
	}

	public String name() {
		return "TitForTat";
	}

	public void receiveLastResponse(int opponentAnswer) {
		opponentResponse = opponentAnswer;
	}
	public void newOpponent(){ opponentResponse = -1; }

}
