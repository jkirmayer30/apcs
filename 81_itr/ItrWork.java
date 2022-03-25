
/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    QCC
    SUMMARY THE FIRST:
    SUMMARY THE SECOND:
**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                LList<Integer> L )
  {
    int lSize = L.size();
    for (int idx = 0; idx<lSize ; lSize++){
      if (L.get(idx).equals(key)){
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                LList<Integer> L )
  {
    LLIterator<Integer> itr = L.iterator();
    System.out.println(L);
    while (itr.hasNext()){
      if (itr.next().equals(key)){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static LList<Integer> oddsA( LList<Integer> L )
  {
    LList<Integer> oddList = new LList<Integer>();
    for(int idx = 0; idx<L.size();idx++){
      Integer num = L.get(idx);
      if (num%2==1){
        oddList.add(num);
      }
    }
    return oddList;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static LList<Integer> oddsB( LList<Integer> L )
  {
    LList<Integer> oddList = new LList<Integer>();
    LLIterator<Integer> itr = L.iterator();
    System.out.println(L);
    while (itr.hasNext()){
      Integer num = itr.next();
      if (num%2==1){
        oddList.add(num);
      }
    }
    return oddList;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( LList<Integer> L )
  {
    LLIterator<Integer> itr = L.iterator();
    while (itr.hasNext()){
      Integer num = itr.next();
      if (num%2==0){
        itr.remove();
      }
    }
  }


  public static void main( String [] args )
  {
    //var type: List   obj type: ?
    LList<Integer> L = new LList<Integer>();
    for( int i = 0; i < 10; i++ )
      L.add(i);
    // TASK: write code to print the contents of L...
    // a) using a FOREACH loop
    // b) explicitly using an iterator
    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );
    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );
    System.out.println("\nTesting oddsA...");

    LList<Integer> A = oddsA(L);
    for( int n=0;n<A.size();n++) {
      System.out.println(A.get(n));
    };
    System.out.println("\nTesting oddsB...");
    LList<Integer> B =  oddsB(L);
    for( int n=0;n<B.size();n++) {
      System.out.println(B.get(n));
    };
    System.out.println("\nTesting removeEvens...");

    removeEvens(L);
    for( int n=0;n<L.size();n++) {
      System.out.println(L.get(n));
    };

  }//end main

}//end class ItrWork
