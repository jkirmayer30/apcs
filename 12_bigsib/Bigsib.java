/*
Apcs Hw 12 Jacob Kirmayer Period 6
Discoveries:none
Unresolved questions: none
*/

public class Bigsib {
private String greeting;
    public Bigsib (){
    greeting = "word up";
}
    public void setHelloMsg(String message){
        greeting = message;
    }

    public String greet(String input){
        return (greeting+" "+input);
    }

}
