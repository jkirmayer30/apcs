import java.util.*;
import java.util.Scanner;

/**
 * The framework for the Celebrity Game project
 *
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */
	 Celebrity currentCelebrity;
	/**
	 * The GUI frame for the Celebrity game.
	 */

	/**
	 * The ArrayList of Celebrity values that make up the game
	 */
	 ArrayList<Celebrity> _list;

	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame(ArrayList<Celebrity> list)
	{
		_list = list;
	}

	/**
	 * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
	 */
	 public void prepareGame()
 	{
 		_list = new ArrayList<Celebrity>();
 	}

	/**
	 * Determines if the supplied guess is correct.
	 *
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 */
	 //         spaces.
	public boolean processGuess(String guess)
	{
		return guess.equals(currentCelebrity.getAnswer());
	}

	/**
	 * Asserts that the list is initialized and contains at least one Celebrity.
	 * Sets the current celebrity as the first item in the list. Opens the game
	 * play screen.
	 */
	public void play()
	{
		long start = System.currentTimeMillis();
		int points = 0;
		while (_list.size()>0){
			currentCelebrity = _list.get(0);
			System.out.println((10000-(System.currentTimeMillis()-start))/1000+" sec remaining");
			System.out.println(sendClue());
			Scanner newScan = new Scanner(System.in);
			String guess = newScan.nextLine();
			if (System.currentTimeMillis()>start+10000){
				System.out.println("time over, last guess not registered");
				System.out.println(points + " points accumulated");
				break;
			}
			if (processGuess(guess)){System.out.println("correct");}else {System.out.println("wrong");}
			_list.remove(0);
		}
	}

	/**
	 * Adds a Celebrity of specified type to the game list
	 *
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
		Celebrity newCelebrity = new Celebrity(name, guess);
		_list.add(newCelebrity);
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
		return (name.length() >= 4);
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type)
	{
		return (clue.length() >= 10);
	}

	/**
	 * Accessor method for the current size of the list of celebrities
	 *
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
	{
		return _list.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 *
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		return currentCelebrity.getClue();
	}

	/**
	 * Accessor method for the games answer to maintain low coupling between
	 * classes
	 *
	 * @return The String answer from the current celebrity.
	 */
	public String sendAnswer()
	{
		return currentCelebrity.getAnswer();
	}

	public static void main(String[] args){
    ArrayList<Celebrity> list = new ArrayList<Celebrity>();
    for (int i = 0; i<10;i++){
      list.add(new Celebrity("celebrity "+i,"hint "+i));
    }
    CelebrityGame game = new CelebrityGame(list);
    game.play();
  }
}
