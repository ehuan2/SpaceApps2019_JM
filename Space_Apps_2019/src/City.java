import java.awt.*;

public class City {

    String name; // name
    int level; // level that it is at, if it is below sea level, will technically "drown"
    Image image; // image that will be added
    int income; //income of cities

    public City(){

    }

    //constructor for city
    public City(String nme, int sLvl, Image img, int inc){
    
        this.name = nme;
        this.level = sLvl;
        this.image = img;
        this.income = inc;
    
    }


}
