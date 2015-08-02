package game;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map.Entry;
/**
 * A separate class to store the scores, edit them depending on the outcome of each game, and to list them in order from first to last place
 * @author lphemphill
 * 7/31/15
 */
public class Scores {
	HashMap<String, Integer> internal;
	/**
	 * Constructor
	 * @param start Intial HashMap instantiated in TournamentPlatform which already contains the Players and set all the scores at 0.
	 */
	public Scores(HashMap<String, Integer> start){
		internal = start;
	}
	/**
	 * Changes the value for an entry in the HashMap, adding to the score
	 * @param name The name of the player whose score is being changed
	 * @param add The number that is being added to the old score
	 */
	public void changeScore(String name, int add){
		int old = internal.get(name);
		internal.replace(name, old+add);
	}
	
	/**
	 * Prints the results in order
	 */
	public void list(){
		HashMap<Integer, String> reversed = new HashMap<Integer, String>();
		Iterator<Entry<String, Integer>> it = internal.entrySet().iterator();
		int[] scores = new int[internal.size()];
		
		int i = 0;
		while (it.hasNext()) {
			HashMap.Entry<String, Integer> pair = (HashMap.Entry<String, Integer>)it.next();
			scores[i] = pair.getValue();
			i++;
			
			//How to handle the case of two names having the same score without it being too weighty/complicated?
			if(!reversed.containsKey(pair.getValue())){
				reversed.put(pair.getValue(), pair.getKey());
			}
			it.remove();
		}
		Arrays.sort(scores);
		for(int j = 0; j < scores.length; j++){
			System.out.println(j+1 + ". " + reversed.get(scores[j]) + "        Score: " + scores[j]);
		}
	}
}
