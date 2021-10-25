/*
Melody Lew
APCS pd 6
HW23 -- What Does Equality Look Like?
2021-10-22
time spent: 1.0 hrs
*/

/*
DISCO:
0. "this" refers to "this object" in an instance method or constructor.
1. ++ and +=1 are interchangeable.
QCC:
0. Why is assignValue private?
1. In what other cases can we use "this"?
*/

import java.lang.Math;

public class Coin {

  //attributes aka instance vars
  private double value; // monetary worth
  private String upFace; // face showing currently. (“heads” or “tails”)
  private String name; // “penny”, “nickel”, etc.
  private int flipCtr; // number of times this coin has been flipped
  public int headsCtr; // number of times this coin has landed heads-up
  public int tailsCtr; // number of times this coin has landed tails-up
  private double bias; // likelihood of landing heads-up every time (1.0) or tails-up every time (0.0)



  /***
   *  Coin() -- default constuctor
   *  precond: n/a
   *  postcond: n/a
   ***/
  public Coin() {
    upFace = "heads";
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond: n/a
  ***/
  public Coin( String s ) {
    value = assignValue(s);
    upFace = "heads";
    name = s;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }


  /***
      Coin(String,String) --
      precond: n/a
      postcond: n/a
  ***/
  public Coin( String s, String nowFace ) {
    value = assignValue(s);
    upFace = nowFace;
    name = s;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (s == "penny"){
      value = 0.01;
    }
    if (s == "nickel"){
      value = 0.05;
    }
    if (s == "dime"){
      value = 0.1;
    }
    if (s == "quarter"){
      value = 0.25;
    }
    if (s == "half dollar"){
      value = 0.5;
    }
    if (s == "dollar"){
      value = 1.0; //have to add .0 because double
    }
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
    upFace = s;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = d;
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    flipCtr += 1;
    if (bias > Math.random()){
      headsCtr += 1; //equivalent to headsCtr += 1
      upFace = "heads";
    }
    else { // bias < Math.random
      tailsCtr += 1;
      upFace = "tails";
    }
    return upFace;
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    return this.upFace == other.upFace;
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    return name + " - " + upFace;
  }

}//end class
