

public class Main {


    static City[] cities = new City[11];
    static String[] cityNames = {"Houston","St. Johns","Miami","Los Angeles","New York City","Vancouver","San " +
            "Fransisco","Boston","New Orleans","Victoria", "Honolulu","Toronto"};
    static int[] citySeaLvls = {32,35,2,87,10,52,16,43,-2,23,6,76};
    static int[] cityEcons = {1,2,3,4,5,6,7,8,9,10,11,12};
    static int[] cityCitz = {1,2,3,4,5,6,7,8,9,10,11,12};
    static int[] seaWallHeight = {5,5,1,2,5,3,2,0,6,4,8,0};

    public static void main(String[] args) {

        //filling cities with actual cities
        finCits();

    }

    //initializing new cities
    static void finCits(){

        for (int i = 0; i < cities.length; i++){

            cities[i] = new City(cityNames[i],citySeaLvls[i],cityEcons[i],cityCitz[i], seaWallHeight[i]);
            //System.out.println(cities[i].toString()); for testing purposes
        }


    }
}
