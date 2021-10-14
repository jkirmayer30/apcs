public class BankAccount {
public String name="";
private String password="";
private int pin=1;
public int accountNumber=1;
private double accountBalance=1;
public void setInfo(String newName, String newPassword, int newPin,
String oldPassword, int oldPin){
if (oldPassword==password&&oldPin==pin){
name = newName;
pin = newPin;
password = newPassword;
}
}

public void printInfo(String pass, int pinn){
if (pass==password&&pinn==pin){
System.out.println(name);
}
}

public void deposit(double amt){
accountBalance += amt;
}

public void withdraw(String pass, int pinn, double amt){
if (pass==password&&pinn==pin&&accountBalance >= amt){
accountBalance -= amt;
}
}

public static void main(String[] args){
BankAccount richard = new BankAccount();
richard.setInfo("richard","richard",2,"",1);
richard.printInfo("ichard",2);
}
}

