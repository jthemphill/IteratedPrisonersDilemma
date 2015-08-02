package game;
/**
 * Begins by betraying, if its opponent retaliates, it plays TitForTat. If the opponent does not retaliate, it betrays 40% of the time
 * @author Originally part of an IPD tournament, written for java by lphemphill
 * 8/1/15
 */
public class Tester implements Player{

	private int opponentResponse;
	private int firstResponse;
	
	public Tester(){
		firstResponse = -1;
		opponentResponse = -1;
	}
	public int play() {
		//On the first turn, defect
		if(opponentResponse == -1) return 1;
		//If the opponent retaliated, play Tit for Tat
		if(firstResponse == 1){
			//System.out.print("Retaliated   ");
			return opponentResponse;
		}
		//If the opponent did not retaliate, intersperse answers
		//System.out.print("Intersperse   ");
		int percent = (int) Math.floor(Math.random()*101);
		if(percent <= 40){
			return 1;
		}
		else return 0;
		
	}

	public String name() {
		return "Tester";
	}

	public void receiveLastResponse(int opponentAnswer) {
		if(firstResponse == -1){
			firstResponse = opponentAnswer;
		}
		opponentResponse = opponentAnswer;
	}
	public void newOpponent(){
		opponentResponse = -1;
		firstResponse = -1;
	}

}
