package game;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * The platform for playing a game of Iterated Prisoner's Dilemma
 * Here, the players and scoreboard are instantiated, and the players are made to play against one another
 * @author lphemphill
 * 7/31/15
 */
public class TournamentPlatform {
	public static void main(String[] args){

		
		//ArrayList of players
		ArrayList<Player> players = new ArrayList<Player>();
		
		//WHERE PLAYERS ARE INSTANTIATED, ADD YOURS HERE.
		
		players.add(new TitForTat());
		players.add(new Betrayer());
		players.add(new Random());
		players.add(new Friedman());
		players.add(new Joss());
		players.add(new Tester());
		//Is always silent, making it a terrible player. Feel free to add it in as it often changes results, making Betrayer do much better.
		players.add(new Silent());
		
		//HashMap for scores so players cannot change their own scores
		HashMap<String, Integer> playerScores = new HashMap<String, Integer>();
		for(Player current : players){
			playerScores.put(current.name(), 0);
		}
		Scores scores = new Scores(playerScores);
		
		//Amount of times each player will play against another, should be generated randomly between 50 and 150 iterations
		int iterations = (int)(Math.random() * ((151 - 50) + 1) + 50);
		
		//Each player should play against each other player
		for(int i = 0; i < players.size(); i++){
			 Player player1 = players.get(i);
			 for(int j = i+1; j < players.size(); j++){
				 Player player2 = players.get(j);
				 for(int k = 0; k < iterations; k++) play(player1, player2, scores);
				 player1.newOpponent();
				 player2.newOpponent();
			 }
		}
		
		//Print final scores
		System.out.println("The winner has the lowest score");
		scores.list();
		
	}

	/**
	 * The play method gets info and gives info to the players, allowing them to give their response and hear their opponent's response,
	 * and also passes info to the scoreboard
	 * @param player1 The first player
	 * @param player2 The second player
	 * @param scores The place where the scores are stored
	 */
	public static void play(Player player1, Player player2, Scores scores){
		
		//These ints explain how the round is scored depending on each outcome.
		final int silentSilent = 1;
		final int silentBetray = 3;
		final int betraySilent = 0;
		final int betrayBetray = 2;
		
		//0 means silent, 1 means betray
		int response1 = player1.play();
		int response2 = player2.play();
		player1.receiveLastResponse(response2);
		player2.receiveLastResponse(response1);
		
		if(response1 == 0 && response2 == 0){
			scores.changeScore(player1.name(), silentSilent);
			scores.changeScore(player2.name(), silentSilent);
		}
		if(response1 == 0 && response2 == 1){
			scores.changeScore(player1.name(), silentBetray);
			scores.changeScore(player2.name(), betraySilent);
		}
		if(response1 == 1 && response2 == 0){
			scores.changeScore(player1.name(), betraySilent);
			scores.changeScore(player2.name(), silentBetray);
		}
		if(response1 == 1 && response2 == 1){
			scores.changeScore(player1.name(), betrayBetray);
			scores.changeScore(player2.name(), betrayBetray);
		}
	}
	
}
