public class RunMed {
  ALMinHeap bigVals;
  ALMaxHeap lilVals;
  public RunMed() {
    bigVals = new ALMinHeap();
    lilVals = new ALMaxHeap();
  }

  public void add(Integer addVal){
    if (bigVals.size()==0) {
      bigVals.add(addVal);
      return;
    }

    if (lilVals.size()==0) {
      if (addVal>bigVals.peekMin()){
        lilVals.add(bigVals.peekMin());
        bigVals.add(addVal);
      } else {lilVals.add(addVal);}
      return;
    }

    if (addVal>= lilVals.peekMax())
      bigVals.add(addVal);
    else
      lilVals.add(addVal);
    if (lilVals.size()>bigVals.size())
      bigVals.add(lilVals.removeMax());
    else if (lilVals.size()< bigVals.size()-1)
      lilVals.add(bigVals.removeMin());
  }

  public double getMedian(){
    if (bigVals.size()==lilVals.size())
      return (bigVals.peekMin()+ lilVals.peekMax())/2.0;
    else
      return (double) bigVals.peekMin();
  }
}
