
public class CityGame extends City {

    // the citygame is part of city, but has added stuff like citizen happiness
    // economy at a level, citizen

    double morale = 1.0; // between 0 and 1
    double growth; // economic growth
    double growthCitizens; // growth rate of citizens
    int land; // land mass
    int birthRate; // birth rate
    int deathRate; // death rate
    double tempRise; // temp rise based on how well the economy is doing, affects sea level
    double minMorale = 0.75; // can change later based on difficulty
    final int mincitizenNeed = 40000; // changes later based on difficulty

    // turn based year, by 1 year
    public void changeYear(){
        // birth rate and death rates are functions of the income per capita and canada's gdp
            // canada's gdp per capita is 46213, our birth rate is 10/1000 and the death rate is 9/1000
        birthRate = 10/(1000/46213*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        deathRate = 9/(1000/46213*incomePerCapita); // needs to add the rate difference based on the land mass/pop density
        growthCitizens = (birthRate-deathRate)/citizens;

        citizens *= growthCitizens;

        growth =
                tempRise = 1.7*incomeTotal/2000000; // based on the Toronto's fake GDP and the real rise in temp
        level += tempRise;
        land -= (level-seaWall > 0) ? (level-seaWall)*tempRise : 0; // this can be tweaked later


        updateMorale();

    }

    public void updateMorale(){




    }


}
