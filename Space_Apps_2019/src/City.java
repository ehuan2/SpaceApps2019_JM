
public class City {

    String name; // name
    double level; // level of city
    int incomeTotal; //income of cities
    int citizens; //number of citizens in a city
    int incomePerCapita; // income per person
    int seaWall; //height of city seawall
    double waterLevel;

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
        this.incomeTotal = inc;
        this.citizens = citz;
        this.seaWall = cWall;

    }

    public String toString(){

        String strCitInfo = this.name + ", " + this.level + ", " + this.incomeTotal + ", " + this.citizens + ", " + this.seaWall;

       return  strCitInfo;
    }


}
