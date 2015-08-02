package game;
/**
 * Acts like a sneakier Tit for Tat. It always betrays after being betrayed, and if it's opponent is silent, 90% of the time it will also be silent
 * @author Originally part of an IPD tournament, written for java by lphemphill
 * 7/31/15
 */
public class Joss implements Player{

	private int opponentResponse;
	
	public Joss(){
		opponentResponse = -1;
	}
	public int play() {
		if(opponentResponse == 1) return 1;
		int percent = (int) Math.floor(Math.random()*101);
		if(percent <= 10){
			return 1;
		}
		else return 0;
	}

	public String name() {
		return "Joss";
	}

	public void receiveLastResponse(int opponentAnswer) {
		opponentResponse = opponentAnswer;
	}
	public void newOpponent(){ opponentResponse = -1; }

}
