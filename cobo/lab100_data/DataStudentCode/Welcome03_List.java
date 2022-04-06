import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03_List {


   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name",
              "station/station_id", "station/state",
              "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      int count = 0;
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
            count++;
         }
      }
      System.out.println(count);

      WeatherStation mostSouth = null;
      for (WeatherStation ws : allstns) {
         if ( mostSouth == null || ws.getLat() <= mostSouth.getLat()){
            mostSouth = ws;
         }
      }
      System.out.println(" The most south station is " + mostSouth.getId() + ": " + mostSouth.getName());
   }
}
