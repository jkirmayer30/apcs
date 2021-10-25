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
    pin = newPin;
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    acctNum = newAcctNum;
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public void withdraw( double withdrawAmount ) {
    balance = balance - withdrawAmount;
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


  //main method for testing
  public static void main( String[] args ) {
    // INSERT YOUR METHOD CALLS FOR TESTING HERE
    BankAccount ba = new BankAccount();
ba.setName("Thluffy");
ba.setPasswd("Thluffy");
short twelve = 12;
System.out.println(ba.setPin(twelve));
short twenty2 = 22;
System.out.println(ba.setPin(twenty2));
int twelve2 = 12;
System.out.println(ba.setAcctNum(twelve2));
int twenty22 = 22;
System.out.println(ba.setAcctNum(twenty22));
double twelve22 = 12;
System.out.println(ba.setBalance(twelve22));
double twenty222 = 22;
System.out.println(ba.setBalance(twenty222));
double twelve222 = 12;
ba.deposit(twelve2);
double twenty2222 = 22;
ba.withdraw(twenty22);
System.out.println(ba.setBalance(twenty222));

  }//end main()

}//end class BankAccount
