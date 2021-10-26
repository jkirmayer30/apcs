/*
APCS
Jacob Kirmayer
10/25
time spent: 40 mins of class and 5min at home
*/


public class Driver {

  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin


    //test default constructor
    /*===================TOP========================== */
      Coin mine = new Coin();

      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );

      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );

      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);

      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      while (wayne.headsCtr<20){
        wayne.flip();
      }
      int matches = 0;
      while (matches<20){
        if (wayne.equals(yours)){
          matches+=1;
        }
        wayne.flip();
      }
      matches = 0;
      boolean keepGoing = true;
      while (keepGoing){
        if (wayne.equals(yours)){
          matches+=1;
        }
        if (matches>65536&&matches%2005==0){
          keepGoing = false;
        }
        wayne.flip();
      }
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);

      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }
     /* ====================BOTTOM======================*/

  }//end main()

}//end class
