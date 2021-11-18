/*****************************************************
 * Jacob Kirmayer
 * APCS pd6
 * HW38 -- Shmoney
 * 2021-11-18
 * Time Taken: 0.4 hours
 *
 * DISCO: In java, there are many cases where an equals sign is interpreted as a pointer
 * instead of an assignment
 * 
 * QCC: Will the = operator point to anything with a specified memory location?
 *****************************************************/

import java.util.Arrays;
public class Slots {

	//instance variable to represent master copy for slot machine
	public static final String[] FRUITS = {
		"lime",
		"lime",
		"lime",
		"lemon",
		"lemon",
		"lemon",
		"cherry",
		"cherry",
		"cherry",
		"orange", "orange", "orange", 
		"grapefruit", "grapefruit", "grapefruit", 
		"tangerine", "tangerine", "tangerine", 
		"ugli", "ugli", "ugli", 
		"peach",
		"peach",
		"peach"
	};

	private String[] _fruits = new String[FRUITS.length]; //to be init'd by each instance


	/*=====================================
	  Slots() -- default constructor
	  pre:  constant array FRUITS exists, has been initialized
	  post: mutable array _fruits contains same elements as FRUITS
	  =====================================*/
	public Slots() {
		for (int idx = 0; idx<_fruits.length;idx++){
			_fruits[idx] = FRUITS[idx];
		}	
	}


	/*=====================================
	  String toString() -- overrides inherited toString()
	  pre:  
	  post: returns String of elements in slots 0 thru 2, separated by tabs
	  =====================================*/
	public String toString() {
		return _fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2];
	}


	/*=====================================
	  void swap(int,int) -- array swap util fxn
	  pre:  _fruits array exists
	  post: elements at indices i, j are swapped
	  =====================================*/
	private void swap(int i, int j) {
		String[] temp = _fruits;
		String tempi = _fruits[j];
		String tempj = _fruits[i];
		temp[i] = tempi;
		temp[j] = tempj;
		_fruits = temp;
	}

	public static int randIntExclusive (int arrayLength, int idx){
		int randInt = (int) (Math.random()*(arrayLength-1));
		if (randInt>=idx){
			randInt++;
		}
		return randInt;
	}

	/*=====================================
	  void spinOnce() -- simulate a pull of the slot machine lever
	  pre:  _fruits array exists
	  post: randomized order of elements in _fruits array
	  =====================================*/

	public void spinOnce() {
		// A simple approach to shuffling:
		// iterate through the array, swapping
		// the val at each index with a randomly chosen other index
		for (int a = 0; a < _fruits.length; a++) {
			swap(a,randIntExclusive(_fruits.length,a));
		}
	}


	/*=====================================
	  boolean jackpot() -- checks for a winning combo
	  pre:  _fruits is existing array
	  post: returns true if first 3 slots represent winning combo,
	  false otherwise
	  =====================================*/
	public boolean jackpot() {
		boolean retBoo = _fruits[0].equals("lime")&&_fruits[1].equals("lime")&&_fruits[2].equals("lime");
		return retBoo;
	}


	/*=====================================
	  boolean miniWin() -- checks for a winning combo
	  pre:  _fruits is existing array
	  post: returns true if first 3 slots represent winning combo,
	  or if first 3 slots mutually distinct, 
	  false otherwise
	  =====================================*/

	public boolean miniWin() {
		boolean retBoo = jackpot()||(!(_fruits[0].equals(_fruits[1]))
		&&!(_fruits[1].equals(_fruits[2]))&&!(_fruits[2].equals(_fruits[0])));
		return retBoo;
	}


	//main() method for testing
	public static void main(String[] args) {
		//usage: move bar below down 1 line at a time to test functionality...


		Slots machine01 = new Slots();
		Slots machine02 = new Slots();
		//test to verify slot machines function indepently
		System.out.println();
		System.out.println( "Machine01 initial state:\t" + Arrays.toString(machine01._fruits) );
		System.out.println( "Machine02 initial state:\t" + machine02 );
		
		System.out.println( "\nSpinning machine01...\n" );
		machine01.swap(0,5);
		System.out.println( "Machine01 state:\t" + Arrays.toString(machine01._fruits) );
		System.out.println( "Machine02 state:\t" + machine02 );
		System.out.println();
		
		//test gamble-until-you-win mechanism
		System.out.println( "Preparing to spin until a mini win! . . ." );
		System.out.println( "------------------------------------" );
		//if you haven't won, spin again until you win!
		
		int tries = 20;
		while( machine01.miniWin() == false &&tries>0) {
		  System.out.println( "Your spin..." + "\t" +Arrays.toString(machine01._fruits) );
		  System.out.println( "LOSE\n" );
		  machine01.spinOnce();
		  tries--;
		}
	
		System.out.println( "====================================" );
		System.out.println( "Your spin..." + "\t" + machine01 );
		System.out.println( "WIN\n" );
		System.out.println( "Preparing to spin until...jackpot! . . ." );
		System.out.println( "------------------------------------" );
		//if you haven't won, spin again until you win!
		while( machine01.jackpot() == false ) {
		  System.out.println( "Your spin..." + "\t" + machine01 );
		  System.out.println( "LOSE\n" );
		  machine01.spinOnce();
		}
		System.out.println( "====================================" );
		System.out.println( "Your spin..." + "\t" + machine01 );
		System.out.println( "JACKPOT!\n" );
		
	} //end main

} //end class Slots
