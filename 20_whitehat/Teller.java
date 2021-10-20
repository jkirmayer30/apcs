/*
Apcs homework 20
Jacob Kirmayer
disco:none
qcc:none
*/

public class Teller{
  public static void main(String[] args){
    BankAccount apple = new BankAccount();
    apple.setAcctNum(100000000); //should be able to have this acct Number
    apple.setPin((short) 1000); //should be able to have this pin
    apple.deposit((double) -1000000000); //shouldn't be able to rob the bank
    System.out.println(apple.toString());
  }
}
