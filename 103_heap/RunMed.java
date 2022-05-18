public class RunMed {
  ALMinHeap bigVals;
  ALMaxHeap lilVals;
  public RunMed() {
    bigVals = new ALMinHeap();
    lilVals = new ALMaxHeap();
  }

  public void add(Integer addVal){
    if (addVal>bigVals.peekMin())
      bigVals.add(addVal);
    else
      lilVals.add
  }
}
