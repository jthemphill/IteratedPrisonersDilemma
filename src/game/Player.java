package game;
/**
 * An interface for creating new Players for a game of Iterated Prisoner's Dilemma
 * @author lphemphill
 * 7/31/15
 */
public interface Player {
	/**
	 * A game of PD has started, returns 0 to stay silent or 1 to betray
	 * @return int Response for this game
	 */
	public int play();
	/**
	 * The name of the player
	 * @return name Your player's name
	 */
	public String name();
	/**
	 * The player is given the last response of its opponent, and can choose to use the info to inform future decisions
	 * @param opponentAnswer The last answer your opponent gave
	 */
	public void receiveLastResponse(int opponentAnswer);
	/**
	 * The player is simply prompted that it is playing against a new opponent, and can choose to use the info to reset the info it may have gathered
	 */
	public void newOpponent();
}
