import java.util.*;

public class MySorts{
  public static void bubble( ArrayList<Comparable> data )
  {
      int swapCount = 0;
      if (data.size() <= 1) {
        System.out.println(swapCount);
        return;
      }
      else {
          for (int i = 0; i < data.size() - 1; i++) {
              for (int j = data.size() - 1; j > i; j--) {
                  if (data.get(j).compareTo(data.get(j-1)) < 0) {
                      Comparable temp = data.get(j);
                      data.set(j, data.get(j-1));
                      data.set(j-1, temp);
                      swapCount++;
                  }
              }
          }
          System.out.println(swapCount);
          return;
      }
  }

  public static void selection( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int swapCount = 0;
    for( int pass = 1; pass<=data.size();pass++ ) {
      int maxPos=0;
      for(int idx = 0;idx<=data.size()-pass;idx++) {
        if (data.get(maxPos).compareTo(data.get(idx))<0){
          maxPos = idx;
        }
      }
      swapCount++;
      Comparable temp = data.get(maxPos);
      data.set(maxPos,data.get(data.size()-pass));
      data.set(data.size()-pass,temp);
    }
    System.out.println(swapCount);
  }//end selectionSort

  public static void insertion( ArrayList<Comparable> data )
  {
    int swapCount = 0;
    for( int partition = 1 ; partition < data.size() ; partition++ ) {
      //partition marks first item in unsorted region
      //traverse sorted region from right to left
      for( int index = partition - 1 ; index >= 0; index-- ) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(index).compareTo(data.get(index + 1)) > 0) {
          Comparable temp = data.get(index);
          data.set(index, data.get(index +1));
          data.set(index +1, temp);
          swapCount++;
        }
        else
          break;
      }
    }
    System.out.println(swapCount);
  }//end insertionSortV
}
