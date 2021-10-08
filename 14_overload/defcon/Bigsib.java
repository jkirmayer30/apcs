/*
Apcs Hw 14 Jacob Kirmayer Period 6
Discoveries:none
Unresolved questions: none
*/

public class Bigsib {
    public String greeting;

    public Bigsib(){
        greeting = "word up";
    }

    public void setHelloMsg(String message){
        greeting = message;
    }

    public String greet(String input){
        return (greeting+" "+input);
    }

}
