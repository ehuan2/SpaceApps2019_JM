
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
    public City(String nme, int sLvl, double inc, double citz, int cWall){

        this.level = sLvl;
        this.name = nme;
        this.incomeTotal = (int)inc;
        this.citizens = (int)citz;
        this.seaWall = cWall;
        incomePerCapita = incomeTotal/citizens;
        System.out.println("income per person " + incomePerCapita);
    }

    public String toString(){

        String strCitInfo = this.name + ", " + this.level + ", " + this.incomeTotal + ", " + this.citizens + ", " + this.seaWall;

       return  strCitInfo;
    }


}
