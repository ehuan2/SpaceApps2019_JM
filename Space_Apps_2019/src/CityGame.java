
import java.awt.*;

public class CityGame extends City {

    // the citygame is part of city, but has added stuff like citizen happiness
    // economy at a level, citizen

    double morale = 1.0; // between 0 and 1
    double growth; // economic growth
    double growthCitizens; // growth rate of citizens

    double land; // land mass
    double birthRate; // birth rate
    double deathRate; // death rate
    double tempRise; // temp rise based on how well the economy is doing, affects sea level
    final double minMorale; // can change later based on difficulty
    final int minCitNeed; // changes later based on difficulty
    final double costPerMeter;
    final double initialLand;
    int year = 2019;
    int count = 0;

    static boolean endGame = false;

    public CityGame(){
        minCitNeed = 10000;
        costPerMeter = 10000;
        initialLand = 100;
        minMorale = 0.8;
    }

    public CityGame(String nme, int sLvl, double inc, double citz, int cWall, Image image, double land, int minCitNeed, double costPerMeter, double minMorale){
        super(nme, sLvl, inc, citz, cWall, image);
        this.minMorale = minMorale;
        this.land = land;
        initialLand = this.land;
        this.minCitNeed = minCitNeed;
        this.costPerMeter = costPerMeter;
    }

    public CityGame(City city, double land, int minCitNeed, double costPerMeter, double minMorale){
        super(city.name, (int)city.level, city.incomeTotal, city.citizens, city.seaWall, city.image);
        this.minMorale = minMorale;
        this.land = land;
        initialLand = this.land;
        this.minCitNeed = minCitNeed;
        this.costPerMeter = costPerMeter;
    }

    public CityGame(String nme, int sLvl, double inc, double citz, int cWall, Image image){

        super(nme, sLvl, inc, citz, cWall, image);
        minCitNeed = 10000;
        costPerMeter = 10000;
        initialLand = 100;
        minMorale = 0.8;
    }

    // turn based year, by 1 year
    public void changeYear(){
        year++;
        count++; if(count == 4) { count = 0; }
        // birth rate and death rates are functions of the income per capita and canada's gdp
        // canada's gdp per capita is 46213, our birth rate is 10/1000 and the death rate is 9/1000
        birthRate = 10.0/(1000.0/46213.0*incomePerCapita) * morale + incomeTotal/2000000.0; // needs to add the rate difference based on the land mass/pop density
        deathRate = 9.0/(1000.0/46213.0*incomePerCapita) * (2.0-morale) + citizens/2000000.0 ; // needs to add the rate difference based on the land mass/pop density
        growthCitizens = (birthRate-deathRate)/(double)citizens;

        int oldCitiCount = citizens;
        citizens *= 1.0 + (growthCitizens < -1 ? -1.0 : growthCitizens);
        if(citizens == 0){
            // endGame();
            endGame = true;
            year--;
            System.out.println("CityGame.changeYear " + "game ended, all citizens dead");
            return;
        }

        growth = count == 3 ? 2.0 - ((double)citizens/(double)oldCitiCount*(1.3)) : ((double)citizens/(double)oldCitiCount*(morale-minMorale > 0 ? 1.3 : 1.0+morale-minMorale)); // economic growth

        tempRise = incomeTotal/2000000.0; // based on the Toronto's fake GDP and the real rise in temp
        waterLevel += tempRise*.5;
        land += (((seaWall+level)-waterLevel) > 0) ? 0 : Math.max((((seaWall + level) - waterLevel)), -land); // this can be tweaked later
        System.out.println("Land " + land + " " + (((seaWall+level)-waterLevel))+"\n");
        incomeTotal *= growth * land/initialLand;
        incomePerCapita = incomeTotal/citizens;

        updateMorale();

    }

    private void updateMorale(){

        moraleMoney();
        moraleLevel();


    }

    private void moraleMoney(){

        //amount of money per citizen to go round
        int goRound = this.incomeTotal / this.citizens;

        if( ((goRound - minCitNeed) >= 10000) && (morale <= 0.9) ){
            morale += 0.1;
        } else if( ((goRound - minCitNeed) >= 10000) && (morale <= 0.95) ){
            morale += 0.05;
        } else if( ( (goRound - minCitNeed) <= -10000 ) && (morale >= 0.1) ){
            morale -= 0.1;
        } else if( ( (goRound - minCitNeed) <= -5000 ) && (morale >= 0.05) ){
            morale -= 0.05;
        }

    }

    private void moraleLevel(){
        if(land == 0){
            citizens = 0;
            return;
        }
        double remLand = (land/initialLand);

        if(remLand < 0.1){
            morale = 0.0;
        }else if ( (remLand < 0.5) && (morale >= 0.1)){
            morale -= 0.25;
        }else if ( (remLand <= 0.9) && remLand >= .5 && (morale >= 0.15)){
            morale -= 0.15;
        }else if( (remLand > 0.9) && (morale <= 0.95)){
            morale += 0.05;
        }

    }

    public void addSeaWall(int height){

        incomeTotal -= height*costPerMeter*100;
        if(morale <= 0.9){
            morale += .1;
        }
        seaWall += height;
        incomePerCapita = incomeTotal/citizens;

    }


    public String toString(){
        return "Year " + year + " Morale : " + morale + " Citizens : " + citizens + " Economy " + incomeTotal + "\nTempRise : " + tempRise
                + " Water Level " + waterLevel + " Total level " + (level + seaWall);
    }

}
