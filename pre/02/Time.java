public class Time{
  public static void main(String[] args){
    int hours = 12;
    int minutes = 10;
    int seconds = 00;
    int timePassed = hours *3600 + minutes * 60 + seconds;
    float percent = 100*timePassed / (24 * 60 * 60);
    System.out.println("Seconds elapsed " + timePassed);
    System.out.println("Seconds remaining " + (86400-timePassed));
    System.out.println("Percentage elapsed " + percent);
  }
}