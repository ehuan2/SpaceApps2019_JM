import java.awt.*;

public class City {

    String name; // name
    int level; // level that it is at, if it is below sea level, will technically "drown"
    Image image; // image that will be added
    static City[]cities; // holds all the cities, from the text file allCities,
                            // that text file will contain from order, the name, the level then the image

    public City(){

    }

    public City(String nme, int sLvl){
        name = nme;
        level =  sLvl;
    }

    public City(String nme, int sLvl, Image img){
        name = nme;
        level = sLvl;
        image = img;
    }


}
