
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
    final int minCitNeed = 40000; // changes later based on difficulty
    final double costPerMeter = 2000000;

    // turn based year, by 1 year
    public void changeYear(){
        // birth rate and death rates are functions of the income per capita and canada's gdp
            // canada's gdp per capita is 46213, our birth rate is 10/1000 and the death rate is 9/1000
        birthRate = 10/(1000/46213*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        deathRate = 9/(1000/46213*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        growthCitizens = (birthRate-deathRate)/citizens;

        citizens *= Math.floor(growthCitizens);

        growth = growthCitizens*(1.0+morale-minMorale); // economic growth

        tempRise = 1.7*incomeTotal/2000000; // based on the Toronto's fake GDP and the real rise in temp
        waterLevel += tempRise;
        land -= (waterLevel-(seaWall+level) > 0) ? (level-(seaWall+level))*tempRise : 0; // this can be tweaked later

        incomeTotal *= growth;
        incomePerCapita = incomeTotal/citizens;

        updateMorale();

    }

    public void updateMorale(){




    }

    public void addSeaWall(int height){

        incomeTotal -= height*costPerMeter;
        seaWall += height;
        incomePerCapita = incomeTotal/citizens;

    }


}
