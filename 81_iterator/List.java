/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 **/

public interface List<T>
{
  //add node to list, containing input T as its data
  public boolean add( T x );

  //return data in element at position i
  public T get( int i );

  //overwrite data in element at position i
  public T set( int i, T x );

  //return length of list
  public int size();

  public T remove( int index );

  //add node to list, containing input T as its data
  public boolean add( T x, int index );
}//end interface
