// Team AJ Ari Gurovich, Jacob Kirmayer
// APCS
// HW72
// 2022-03-07
// time spent: 0.5 hrs



public class FastSelect
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o )
    {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    //print input array
    public static void printArr( int[] a )
    {
        for ( int o : a )
            System.out.print( o + " " );
        System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d )
    {
        int tmp;
        int swapPos;
        for( int i = 0; i < d.length; i++ ) {
            tmp = d[i];
            swapPos = i + (int)( (d.length - i) * Math.random() );
            swap( i, swapPos, d );
        }
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal )
    {
        int[] retArr = new int[s];
        for( int i = 0; i < retArr.length; i++ )
            retArr[i] = (int)( maxVal * Math.random() );
        return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------


    /**
     * int mysterion(int[],int,int,int)
     * sorts the array into two sections: One with values less than the
     * target value and one with values greater than the target value
     *
     * @param arr
     * @param firstVal
     * @param lastVal
     * @param target
     * @return int
     *
     */
    public static int twoPiles( int[] arr, int firstVal, int target)
    {
        int v = arr[target];
        int s = firstVal;
        for (int i = firstVal; i < target; i++) {
            if (arr[i] < v) {
                swap(s, i, arr);
                s += 1;
            }
        }
        swap(target, s, arr);
        return s;
    }//end mysterion

    public static int select( int[] arr,int place,int start,int end){
        int barrier = twoPiles(arr,start,end);
        if (barrier==place-1){
            return arr[barrier];
        } else if (barrier<place-1){
            return select(arr,place-barrier-1,barrier+1,arr.length-1);
        } else {
            return select(arr,place,0,barrier-1);
        }
    }


    //main method for testing
    public static void main( String[] args )
    {

        //init test arrays of magic numbers
        int[] arr1 = {8,21,17,69,343};
        int[] arr3 = {1,28,33,4982,37};
        int[] arr4 = {5,4,17,9000,6};
        int[] arr5 = {3,0,16,599,1024};
        int selected = select(arr1,2,0,4);
        System.out.println(selected);

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class FastSelect