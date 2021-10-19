
/*
JPH - Hugo Jenkins, Prattay Dey, Jacob Kirmayer
APCS
HW19-- Mo Money Mo Problems ...MORE AWESOME
2021-10-18
DISCO:
A method can only return one value so there is soemtimes no need for an else
statement.
All types of methods can SOP, no matter their return type(Maybe True?)
QCC:
Is there a way to collapse if statements so they look better and the code
is easier to read?
*/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    if (newPin <= 9998 && newPin >= 1000){
      pin = newPin;
      return oldPin;
    }
    else{
      newPin=9999;
      System.out.println("Account Number out of range [1000,9998]");
    }
    pin = newPin;
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    if (newAcctNum <= 999999998 && newAcctNum >= 100000000){
      acctNum = newAcctNum;
      return oldAcctNum;
    }
    else{
      acctNum=999999999;
      System.out.println("Account Number out of range [100000000,999999998]");
    }
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    if (depositAmount>0){
    balance = balance + depositAmount;
  }
  }

  public boolean withdraw( double withdrawAmount ) {
    if (withdrawAmount <= balance){
      balance = balance - withdrawAmount;
      return true;
    }
    else{
      return false;
    }
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }

  public boolean authenticate(int acctNumm, String passwdd){
    if (acctNumm == acctNum && passwdd==passwd){
      return true;
    }
    return false;
  }

  //main method for testing
  public static void main( String[] args ) {
      // INSERT YOUR METHOD CALLS FOR TESTING HERE
      BankAccount ba = new BankAccount();
  ba.setName("Thluffy");
  ba.setPasswd("Thluffy");
  short twelve = 12;
  System.out.println(ba.setPin(twelve));
  short twenty2 = 2222;
  System.out.println(ba.setPin(twenty2));
  int twelve2 = 12;
  System.out.println(ba.setAcctNum(twelve2));
  int twenty22 = 500000000;
  System.out.println(ba.setAcctNum(twenty22));
  double twelve22 = 12;
  System.out.println(ba.setBalance(twelve22));
  double twenty222 = 22;
  System.out.println(ba.setBalance(twenty222));
  double twelve222 = 12;
  ba.deposit(twelve2);
  double twenty2222 = 22;
  System.out.println(ba.withdraw(0));
  System.out.println(ba.withdraw(1000000));
  System.out.println(ba.setBalance(twenty222));
  System.out.println(ba.authenticate(500000000, "Thluffy"));
  System.out.println(ba.toString()); // Credit to UnicornHead
  }//end main()

}//end class BankAccount
