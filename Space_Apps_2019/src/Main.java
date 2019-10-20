import java.util.*;

public class Main {

    static volatile CityGame userCity;
    static final int yearTime = 10; // they only get thirty seconds to decide to add or not
    static City[] cities = new City[11];
    static String[] cityNames = {"Houston","St. Johns","Miami","Los Angeles","New York City","Vancouver","San " +
            "Fransisco","Boston","New Orleans","Victoria", "Honolulu","Toronto"};
    static int[] citySeaLvls = {32,35,2,87,10,52,16,43,-2,23,6,76};
    static int[] cityEcons = {50000000,50000000,100000000,15000000,60000000,50000000,60000000,20000000,110000000,
            60000000,80000000,20000000};
    static int[] cityCitz = {2000000,2000000,500000,3000000,1000000,6000000,1000000,2000000,500000,1000000,600000,
            3000000};
    static int[] seaWallHeight = {5,5,1,2,5,3,2,0,6,4,8,0};

    public static void main(String[] args) {

        //filling cities with actual cities
        finCits();

        //user picked city
        userCity = new CityGame(new City("Eric", 100, 10000000, 1000000, 0, null), 100, 100, 100, .8);

        Map map = new Map(userCity);

        // Timer timer = new Timer();
        // timer.schedule(new Timing(), 0, yearTime*1000); //30 seconds

    }

    //initializing new cities
    static void finCits(){

        for (int i = 0; i < cities.length; i++){
            cities[i] = new City(cityNames[i],citySeaLvls[i],cityEcons[i],cityCitz[i], seaWallHeight[i], null);
            System.out.println(cities[i]); //for testing purposes
        }


    }
}
