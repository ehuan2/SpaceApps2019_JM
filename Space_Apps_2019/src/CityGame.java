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
    final double minMorale = 0.75; // can change later based on difficulty
    final int minCitNeed; // changes later based on difficulty
    final double costPerMeter;
    final double initialLand;
    int year = 2019;

    public CityGame(String nme, int sLvl, double inc, double citz, int cWall, double land, int minCitNeed, double costPerMeter){
        super(nme, sLvl, inc, citz, cWall);
        this.land = land;
        initialLand = this.land;
        this.minCitNeed = minCitNeed;
        this.costPerMeter = costPerMeter;
    }

    // turn based year, by 1 year
    public void changeYear(){
     year++;
        // birth rate and death rates are functions of the income per capita and canada's gdp
            // canada's gdp per capita is 46213, our birth rate is 10/1000 and the death rate is 9/1000
        birthRate = 10.0/(1000.0/46213.0*incomePerCapita) * morale; // needs to add the rate difference based on the land mass/pop density
        deathRate = 9.0/(1000.0/46213.0*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        growthCitizens = (birthRate-deathRate)/citizens;
        int oldCitiCount = citizens;
        citizens *= 1.0 + Math.ceil(growthCitizens);

        growth = citizens/oldCitiCount*(1.0+morale-minMorale); // economic growth

        tempRise = 1.7*incomeTotal/2000000; // based on the Toronto's fake GDP and the real rise in temp
        waterLevel += tempRise;
        land -= (waterLevel-(seaWall+level) > 0) ? (level-(seaWall+level))*tempRise : 0; // this can be tweaked later

        incomeTotal *= growth;
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

        }else if( ((goRound - minCitNeed) >= 10000) && (morale <= 0.95) ){

            morale += 0.05;

        }else if( ( (goRound - minCitNeed) <= -10000 ) && (morale >= 0.1) ){

            morale -= 0.1;

        }else if( ( (goRound - minCitNeed) <= -5000 ) && (morale >= 0.05) ){

            morale -= 0.05;

        }

    }

    private void moraleLevel(){

        double remLand = (initialLand/land);
        System.out.println("land " + remLand);
        if(remLand < 0.1){
            morale = 0.0;
        }else if ( (remLand < 0.5) && (morale >= 0.1)){
            morale -= 0.1;
        }else if ( (remLand <= 0.7) && (morale >= 0.05)){
            morale -= 0.05;
        }else if( (remLand > 0.9) && (morale <= 0.95)){
            morale += 0.05;
        }

    }

    public void addSeaWall(int height){

        incomeTotal -= height*costPerMeter;
        seaWall += height;
        incomePerCapita = incomeTotal/citizens;

    }


    public String toString(){
        return "Morale : " + morale + " Citizens : " + citizens + " Economy " + incomeTotal + "\nTempRise : " + tempRise
                + " Water Level " + waterLevel + " Total level " + (level + seaWall);
    }

}
