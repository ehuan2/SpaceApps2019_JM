
public class City {

    String name; // name
    int level; // level that it is at, if it is below sea level, will technically "drown"
    int income; //income of cities
    int citizens; //number of citizens in a city
    int seaWall; //height of city seawall

    public City(){

    }

    //constructor for city
    public City(String nme, int sLvl, int inc, int citz, int cWall){

        if (sLvl>cWall){
            this.level = sLvl;
        }else{
            this.level = cWall;
        }
        this.name = nme;
        this.income = inc;
        this.citizens = citz;
        this.seaWall = cWall;

    }

    public String toString(){

        String strCitInfo = this.name + ", " + this.level + ", " + this.income + ", " + this.citizens + ", " + this.seaWall;

       return  strCitInfo;
    }


}
