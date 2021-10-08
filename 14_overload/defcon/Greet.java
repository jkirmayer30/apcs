public class Greet {
    public static void main(String[] args ) {
      String greeting;
          Bigsib richard = new Bigsib();
          Bigsib grizz = new Bigsib();
          Bigsib dotCom = new Bigsib();
          Bigsib tracy = new Bigsib();
          greeting = richard.greet("");
          System.out.println(greeting);
          greeting = grizz.greet("Dr. Spaceman");
          System.out.println(greeting);
          greeting = dotCom.greet("Kong Fooey");
          System.out.println(greeting);
          greeting = tracy.greet("mom");
          System.out.println(greeting);
    } //end main()
  } //end Greet
