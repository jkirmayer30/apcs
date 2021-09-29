import java.util.Scanner;
public class Seconds{
  public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    int total = reader.nextInt();
    int all = total;
    int seconds = total%60;
    total-=seconds;
    total = total/60;
    int minutes = total%60;
    total-=minutes;
    total=total/60;
    System.out.println(all+" seconds is equal to "+total+" hours,"+minutes+" minutes, and "+seconds+" seconds");
  }
}